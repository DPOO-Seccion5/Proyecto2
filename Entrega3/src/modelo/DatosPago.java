package modelo;

public class DatosPago {
	
	private String numero;
	
	private String fechaVencimiento;
	
	private String nombreTitular;
	
	private String numSeguridad;
	
	
	public DatosPago(String elNumero, String laFechaVencimiento, String elNombreTitular, String elNumSeguridad)
	{
		this.numero = elNumero;
		this.fechaVencimiento = laFechaVencimiento;
		this.nombreTitular = elNombreTitular;
		this.numSeguridad = elNumSeguridad;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public String getNombreTitular() {
		return nombreTitular;
	}


	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}


	public String getNumSeguridad() {
		return numSeguridad;
	}


	public void setNumSeguridad(String numSeguridad) {
		this.numSeguridad = numSeguridad;
	}
	
	
	

}
