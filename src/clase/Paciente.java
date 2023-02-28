package clase;

public class Paciente {

	//atributos
	private int codigoPaciente;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String dni;
	
	
	public Paciente(int codigoPaciente, String nombres, String apellidos, String telefono, String dni) {
		this.codigoPaciente = codigoPaciente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
	}


	//metodos getter and setter
	
	public int getCodigoPaciente() {
		return codigoPaciente;
	}


	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
}
