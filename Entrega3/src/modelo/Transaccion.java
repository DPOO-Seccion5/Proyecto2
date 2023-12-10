package modelo;

public class Transaccion {
	
	private ResultadoPago resultadoPago;
	private DatosPago tarjeta;
	private InfoPago informacion;
	public Transaccion(ResultadoPago resultadoPago, DatosPago tarjeta, InfoPago informacion) {
		super();
		this.resultadoPago = resultadoPago;
		this.tarjeta = tarjeta;
		this.informacion = informacion;
	}
	
	
	
	public ResultadoPago getResultadoPago() {
		return resultadoPago;
	}
	public void setResultadoPago(ResultadoPago resultadoPago) {
		this.resultadoPago = resultadoPago;
	}
	public DatosPago getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(DatosPago tarjeta) {
		this.tarjeta = tarjeta;
	}
	public InfoPago getInformacion() {
		return informacion;
	}
	public void setInformacion(InfoPago informacion) {
		this.informacion = informacion;
	}
	
	
	
	

}
