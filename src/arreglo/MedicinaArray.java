package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import clase.Cama;
import clase.Medicina;

public class MedicinaArray {

	//atributos privados
	private ArrayList<Medicina> medicina;
	
	//constructor
	public MedicinaArray() {
		medicina= new ArrayList<Medicina> ();
		loadMedicinas();
	}
	
	//operaciones publicas
	public void addMedicinas(Medicina entity) {
		medicina.add(entity);
		saveMedicinas();
	}
	
	public int sizeArray() {
		return medicina.size();
	}
	
	public Medicina getMedicina(int i) {
		return medicina.get(i);
	}
	
	public Medicina searchMedicina(int codigoMedicina) {
		for (int i = 0; i < sizeArray(); i++) {
			if (getMedicina(i).getCodigoMedicina() == codigoMedicina) {
				return getMedicina(i);
			}
		}
		return null;
	}
	
	public void deleteMedicina(Medicina entity) {
		medicina.remove(entity);
		saveMedicinas();
	}
	
	public void updateMedicina() {
		saveMedicinas();
	}
	
	private void saveMedicinas() {
		try {
			PrintWriter pw;
			String line;
			Medicina x;
			pw= new PrintWriter(new FileWriter("medicinas.txt"));
			for (int i = 0; i < sizeArray(); i++) {
				x=getMedicina(i);
				line= 	x.getCodigoMedicina() + ";" +
						x.getNombre() + ";" +
						x.getLaboratorio() + ";" +
						x.getStock() + ";" +
						x.getPrecioUnitario();
				pw.println(line);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void loadMedicinas() {
		try {
			BufferedReader br;
			String line;
			String[] s;
			int codigoMedicina;
			String nombre, laboratorio;
			int stock;
			double precioUnitario;
			br= new BufferedReader(new FileReader("camas.txt"));
			
			while((line=br.readLine()) != null) {
				s=line.split(";");
				codigoMedicina=Integer.parseInt(s[0].trim());
				nombre = (s[1].trim());
				laboratorio = (s[2].trim());
				stock = Integer.parseInt(s[3].trim());
				precioUnitario= Double.parseDouble(s[4].trim());
				addMedicinas(new Medicina(codigoMedicina,nombre,laboratorio,stock,precioUnitario));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//Operaciones publicas complementarias
	public int numberCorrelative() {
		if (sizeArray() ==0) {
			return 300001;
		}else {
			return getMedicina(sizeArray()-1).getCodigoMedicina() +1;
		}
	}
	

}














