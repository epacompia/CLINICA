package clase;

public class Receta {

	private int codigoMedicina;
	private int cantidad;
	private double precioUnitario;
	
	
	
	public Receta(int codigoMedicina, int cantidad, double precioUnitario) {
		this.codigoMedicina = codigoMedicina;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}


	
	
	

	public int getCodigoMedicina() {
		return codigoMedicina;
	}



	public void setCodigoMedicina(int codigoMedicina) {
		this.codigoMedicina = codigoMedicina;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public double getPrecioUnitario() {
		return precioUnitario;
	}



	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
	
	
}
