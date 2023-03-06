package arreglo;



import clase.Cama;
import java.io.*;
import java.util.ArrayList;

public class CamaArray {

	//atributo privados
	private ArrayList <Cama> cama;
	
	//Constructor
	public CamaArray() {
		cama= new ArrayList<Cama> ();
		loadCamas();
	}
	
	//operaciones publicas
	public void addCamas(Cama entity) {
		cama.add(entity);
		saveCamas();
	}
	
	public int sizeArray() {
		return cama.size();
	}
	
	public Cama getCama(int i) {
		return cama.get(i);
	}
	
	public Cama searchCama(int codigoCama) {
		for (int i = 0; i < sizeArray(); i++) {
			if (getCama(i).getNumeroCama() == codigoCama) {
				return getCama(i);
			}			
		}
		return null;
	}
	
	public void deleteCama(Cama entity) {
		cama.remove(entity);
		saveCamas();
	}
	
	public void updateCama() {
		saveCamas();
	}
	
	private void saveCamas() {
		try {
			PrintWriter pw;
			String line;
			Cama x;
			pw= new PrintWriter(new FileWriter("camas.txt"));
			for (int i = 0; i < sizeArray(); i++) {
				x=getCama(i);
				line= 	x.getNumeroCama() + ";" +
						x.getCategoria() + ";" +
						x.getPrecioDia() + ";" +
						x.getEstado();
				pw.println(line);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void loadCamas() {
		try {
			BufferedReader br;
			String line;
			String[] s;
			int numeroCama, categoria, estado;
			double precioDia;
			br= new BufferedReader(new FileReader("camas.txt"));
			
			while((line=br.readLine()) != null) {
				s=line.split(";");
				numeroCama=Integer.parseInt(s[0].trim());
				categoria = Integer.parseInt(s[1].trim());
				precioDia = Double.parseDouble(s[2].trim());
				estado = Integer.parseInt(s[3].trim());
				addCamas(new Cama(numeroCama, categoria,precioDia,estado));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//Operaciones publicas complementarias
	public int numberCorrelative() {
		if (sizeArray() ==0) {
			return 100001;
		}else {
			return getCama(sizeArray()-1).getNumeroCama() +1;
		}
	}
	
	
}





















