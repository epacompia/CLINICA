package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clase.Medicina;
import clase.Paciente;

public class PacienteArray {

	//ATRIBUTOS PRIVADOS
	private ArrayList<Paciente> paciente;
	
	//Constructor
	public PacienteArray() {
		paciente=new ArrayList<Paciente> ();
		loadPacientes();
	}
	
	//operaciones publicas
	public void addPacientes(Paciente entity) {
		paciente.add(entity);
		savePacientes();
	}
	
	public int sizeArray() {
		return paciente.size();
	}
	
	public Paciente getPaciente(int i) {
		return paciente.get(i);
	}
	
	public Paciente searchPaciente(int codigoPaciente) {
		for (int i = 0; i < sizeArray(); i++) {
			if (getPaciente(i).getCodigoPaciente() == codigoPaciente ) {
				return getPaciente(i);
			}
		}
		return null;
	}
	
	public void deleteMedicina(Paciente entity) {
		paciente.remove(entity);
		savePacientes();
	}
	
	public void updatePaciente() {
		savePacientes();
	}
	
	private void savePacientes() {
		try {
			PrintWriter pw;
			String line;
			Paciente x;
			pw= new PrintWriter(new FileWriter("pacientes.txt"));
			for (int i = 0; i < sizeArray(); i++) {
				x=getPaciente(i);
				line= 	x.getCodigoPaciente() + ";" +
						x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getTelefono() + ";" +
						x.getDni();
				pw.println(line);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	private void loadPacientes() {
		try {
			BufferedReader br;
			String line;
			String[] s;
			int codigoPaciente;
			String nombres, apellidos, telefono,dni;
			
			br= new BufferedReader(new FileReader("pacientes.txt"));
			
			while((line=br.readLine()) != null) {
				s=line.split(";");
				codigoPaciente=Integer.parseInt(s[0].trim());
				nombres = (s[1].trim());
				apellidos= (s[2].trim());
				telefono= (s[3].trim());
				dni= (s[4].trim());
				
				addPacientes(new Paciente(codigoPaciente,nombres,apellidos,telefono,dni));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	
	
	//Operaciones publicas complementarias
		public int numberCorrelative() {
			if (sizeArray() ==0) {
				return 200001;
			}else {
				return getPaciente(sizeArray()-1).getCodigoPaciente() +1;
			}
		}
	
	
}











