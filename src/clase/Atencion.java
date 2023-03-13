package clase;

public class Atencion {

	
	private int codigoAtencion;
	private int codigoPaciente;
	private String fechaAtencion;
	private String horaAtencion;
	private double totalPagar;
	private int estado;
	
	
	public Atencion(int codigoAtencion, int codigoPaciente, String fechaAtencion, String horaAtencion,
			double totalPagar, int estado) {
		this.codigoAtencion = codigoAtencion;
		this.codigoPaciente = codigoPaciente;
		this.fechaAtencion = fechaAtencion;
		this.horaAtencion = horaAtencion;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}

	
	

	public int getCodigoAtencion() {
		return codigoAtencion;
	}


	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}


	public int getCodigoPaciente() {
		return codigoPaciente;
	}


	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}


	public String getFechaAtencion() {
		return fechaAtencion;
	}


	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}


	public String getHoraAtencion() {
		return horaAtencion;
	}


	public void setHoraAtencion(String horaAtencion) {
		this.horaAtencion = horaAtencion;
	}


	public double getTotalPagar() {
		return totalPagar;
	}


	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	@Override
	public String toString() {
		return "Atencion [codigoAtencion=" + codigoAtencion + ", codigoPaciente=" + codigoPaciente + ", fechaAtencion="
				+ fechaAtencion + ", horaAtencion=" + horaAtencion + ", totalPagar=" + totalPagar + ", estado=" + estado
				+ "]";
	}
	
	
}
