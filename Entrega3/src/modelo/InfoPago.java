package modelo;

public class InfoPago {
	
	
	private double monto;
	private String numCuenta;
	private String numTransaccion;
	
	
	public InfoPago(double monto, String numCuenta, String numTransaccion) {
		super();
		this.monto = monto;
		this.numCuenta = numCuenta;
		this.numTransaccion = numTransaccion;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public String getNumCuenta() {
		return numCuenta;
	}


	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}


	public String getNumTransaccion() {
		return numTransaccion;
	}


	public void setNumTransaccion(String numTransaccion) {
		this.numTransaccion = numTransaccion;
	}
	
	
	
	
	
	
	

}
