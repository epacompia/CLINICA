package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clase.Internamiento;

public class InternamientoArray {

	private ArrayList<Internamiento> internamiento;
	
	public InternamientoArray() {
		internamiento = new ArrayList<Internamiento>();
		loadInternamiento();
	}
	
	public void addInternamiento(Internamiento entity) {
		
		internamiento.add(entity);
		saveInternamiento();
	}
	
	public void deleteInternamiento(Internamiento entity) {
		internamiento.remove(entity);
		saveInternamiento();
	}
	
	
	public void updateInternamiento(Internamiento entity) {
		saveInternamiento();
	}
	
	public int sizeArray() {
		
		return internamiento.size();
	}
	
	public Internamiento getInternamiento(int index) {
		
		return internamiento.get(index);
		
	}
	
	public Internamiento searchInternamiento(int codigo) {
		
		
		for(int i=0; i< sizeArray(); i++) {
			if(getInternamiento(i).getCodigoInternamiento() == codigo) {
				getInternamiento(i);
			}
		}
		
		return null;
	}
	
	
	private void saveInternamiento() {
		try {
			
			PrintWriter pw;
			String line;
			Internamiento itm;
			
			pw = new PrintWriter(new FileWriter("internamientos.txt"));
			for (int i = 0; i<sizeArray(); i++) {
				itm = getInternamiento(i);
				line = itm.getCodigoInternamiento() + ";" + itm.getCodigoPaciente() + ";" 
						+ itm.getNumeroCama() + ";" + itm.getFechaIngreso() + ";" 
						+ itm.getHoraIngreso() + ";" + itm.getFechaSalida() + ";"
						+ itm.getHoraSalida() + ";" + itm.getTotalPagar() + ";" + itm.getEstado();
				
				pw.println(line);
			}
			pw.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erroe al registar internamiento");
		}
	}
	
	
	private void loadInternamiento() {
		try {
			
			BufferedReader br;
			String line;
			String[] item;
			int codInternamiento, codPaciente, estado, nroCama;
			double totalPagar;
			String fechaIngreso, horaIngreso, fechaSalida, horaSalida;
			
			br = new BufferedReader(new FileReader("internamientoes.txt"));
			
			while((line = br.readLine()) != null) {
				item = line.split(";");
				codInternamiento = Integer.parseInt(item[0].trim());
				codPaciente = Integer.parseInt(item[1].trim());
				nroCama = Integer.parseInt(item[2].trim());
				fechaIngreso = item[3].trim();
				horaIngreso = item[4].trim();
				fechaSalida = item[5].trim();
				horaSalida = item[6].trim();
				totalPagar = Double.parseDouble(item[7].trim());
				estado = Integer.parseInt(item[8].trim());
				addInternamiento(new Internamiento(codInternamiento,codPaciente,nroCama, fechaIngreso, horaIngreso, fechaSalida, horaSalida, totalPagar, estado));
				
				br.close();
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar internamientos " + e);
			
		}
	}
	
	public int generateCodInternamiento() {
		return sizeArray() == 0 ? 400001 : getInternamiento(sizeArray()-1).getCodigoInternamiento()+1;
	}
	
	
	
}
