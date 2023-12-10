package modelo;

public class ResultadoPago {
	
	private boolean exitoso;
	private String mensaje;
	
	
	public ResultadoPago(boolean esExitoso, String elMensaje){
		this.exitoso = esExitoso;
		this.mensaje = elMensaje;
		
	}


	public boolean isExitoso() {
		return exitoso;
	}


	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	


	
}
