package arreglo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clase.Atencion;

public class AtencionArray {

	private ArrayList<Atencion> atencion;
	
	public AtencionArray() {
		atencion = new ArrayList<Atencion>();
		loadAtencion();
	}
	
	public void addAtencion(Atencion entity) {
		
		atencion.add(entity);
		saveAtencion();
	}
	
	public void deleteAtencion(Atencion entity) {
		atencion.remove(entity);
		saveAtencion();
	}
	
	
	public void updateAtencion(Atencion entity) {
		saveAtencion();
	}
	
	public int sizeArray() {
		
		return atencion.size();
	}
	
	public Atencion getAtencion(int index) {
		
		return atencion.get(index);
		
	}
	
	public Atencion searchAtencion(int codigo) {
		
		
		for(int i=0; i< sizeArray(); i++) {
			if(getAtencion(i).getCodigoAtencion() == codigo) {
				getAtencion(i);
			}
		}
		
		return null;
	}
	
	
	private void saveAtencion() {
		try {
			
			PrintWriter pw;
			String line;
			Atencion atc;
			
			pw = new PrintWriter(new FileWriter("atenciones.txt"));
			for (int i = 0; i<sizeArray(); i++) {
				atc = getAtencion(i);
				line = atc.getCodigoAtencion() + ";" + atc.getCodigoPaciente() + ";" 
						+ atc.getFechaAtencion() + ";" + atc.getHoraAtencion() + ";" 
						+ atc.getTotalPagar() + ";" + atc.getEstado();
				
				pw.println(line);
			}
			pw.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erroe al registar atencion");
		}
	}
	
	
	private void loadAtencion() {
		try {
			
			BufferedReader br;
			String line;
			String[] item;
			int codAtencion, codPaciente, estado;
			double totalPagar;
			String fechaAtencion, horaAtencion;
			
			br = new BufferedReader(new FileReader("atenciones.txt"));
			
			while((line = br.readLine()) != null) {
				item = line.split(";");
				codAtencion = Integer.parseInt(item[0].trim());
				codPaciente = Integer.parseInt(item[1].trim());
				fechaAtencion = item[2].trim();
				horaAtencion = item[3].trim();
				totalPagar = Double.parseDouble(item[4].trim());
				estado = Integer.parseInt(item[5].trim());
				addAtencion(new Atencion(codAtencion,codPaciente, fechaAtencion, horaAtencion, totalPagar, estado));
			}
			
			br.close();
			
			
		} 
		catch (FileNotFoundException fl) {
			JOptionPane.showMessageDialog(null, "No se encontró registro del archivo, se procederá a crear nuevo registro");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar atenciones " + e);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
	}
	
	public int generateCodAtencion() {
		return sizeArray() == 0 ? 400001 : getAtencion(sizeArray()-1).getCodigoAtencion()+1;
	}
	
	
	
}
