package arreglo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import clase.Receta;

public class RecetaArray {

	private ArrayList<Receta> receta;

	public RecetaArray() {

		receta = new ArrayList<Receta>();
		loadReceta();
	}

	public void addReceta(Receta entity) {

		receta.add(entity);
		saveReceta();
	}

	public void deleteReceta(Receta entity) {
		receta.remove(entity);
		saveReceta();
	}

	public void updateReceta(Receta entity) {
		saveReceta();
	}

	public int sizeArray() {

		return receta.size();
	}

	public Receta getReceta(int index) {

		return receta.get(index);

	}

	public List<Receta> searchReceta(int codigo) {
		
		List<Receta> recetas = new ArrayList<Receta>();
		
		for (int i = 0; i < sizeArray(); i++) {
			if (getReceta(i).getCodigoAtencion() == codigo) {
				recetas.add(getReceta(i));
			}
		}

		
		return recetas.isEmpty() ? null : recetas;
	}

	private void saveReceta() {
		try {

			PrintWriter pw;
			String line;
			Receta atc;

			pw = new PrintWriter(new FileWriter("recetas.txt"));
			for (int i = 0; i < sizeArray(); i++) {
				atc = getReceta(i);
				line = atc.getCodigoAtencion() + ";" + atc.getCodigoMedicina() + ";" + atc.getCantidad() + ";"
						+ atc.getPrecioUnitario();

				pw.println(line);
			}
			pw.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al registar receta");
		}
	}

	private void loadReceta() {
		try {

			BufferedReader br;
			String line;
			String[] item;
			int codAtencion, codMedicina, cantidad;
			double precio;

			br = new BufferedReader(new FileReader("recetas.txt"));

			while ((line = br.readLine()) != null) {
				item = line.split(";");
				codAtencion = Integer.parseInt(item[0].trim());
				codMedicina = Integer.parseInt(item[1].trim());
				cantidad = Integer.parseInt(item[2].trim());
				precio = Double.parseDouble(item[3].trim());
				addReceta(new Receta(codAtencion, codMedicina, cantidad, precio));
			}

			br.close();

		} catch (FileNotFoundException fl) {
			JOptionPane.showMessageDialog(null,
					"No se encontró registro del archivo, se procederá a crear nuevo registro");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar recetas " + e);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}

	}

}
