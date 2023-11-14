package modelo;

public class DatosLicencia {
	
	private String numero;
	
	private String paisExpedicion;
	
	private String fechaNacimiento;
	
	
	public DatosLicencia(String elNumero, String elPaisExpedicion, String laFechaNacimiento)
	{
		this.numero = elNumero;
		this.paisExpedicion = elPaisExpedicion;
		this.fechaNacimiento = laFechaNacimiento;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getPaisExpedicion() {
		return paisExpedicion;
	}


	public void setPaisExpedicion(String paisExpedicion) {
		this.paisExpedicion = paisExpedicion;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
