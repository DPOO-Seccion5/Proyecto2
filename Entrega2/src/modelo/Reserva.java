package modelo;

import java.util.ArrayList;

public class Reserva {
	
	
	
	private String categoria;
	
	private String sedeRecogida;
	
	private String sedeDevuelta;
	
	private Cobros cobro;
	
	private String fecha;
	
	private String rangoHoras;
	
	private ArrayList<ConductorExtra> conductoresExtra;
	
	public Reserva(String laCategoria, String laSedeRecogida, String laSedeDevuelta, Cobros elCobro, String laFecha, String elRangoHoras, ArrayList<ConductorExtra> conExtra)
	{  
		
		this.categoria = laCategoria;
		this.sedeRecogida = laSedeRecogida;
		this.sedeDevuelta = laSedeDevuelta;
		this.cobro = elCobro;
		this.fecha = laFecha;
		this.rangoHoras = elRangoHoras;
		this.conductoresExtra = conExtra;
	}
	
	
	
	public ArrayList<ConductorExtra> getConductoresExtra() {
		return conductoresExtra;
	}



	public void setConductoresExtra(ArrayList<ConductorExtra> conductoresExtra) {
		this.conductoresExtra = conductoresExtra;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getCategoria()
	{
		return categoria;
	}
	

	public void setVehiculo(String laCategoria) {
		this.categoria = laCategoria;
	}


	public void setSedeRecogida(String sedeRecogida) {
		this.sedeRecogida = sedeRecogida;
	}


	public void setSedeDevuelta(String sedeDevuelta) {
		this.sedeDevuelta = sedeDevuelta;
	}


	public void setCobro(Cobros cobro) {
		this.cobro = cobro;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public void setRangoHoras(String rangoHoras) {
		this.rangoHoras = rangoHoras;
	}


	public String getSedeRecogida()
	{
		return sedeRecogida;
	}
	
	public String getSedeDevuelta()
	{
		return sedeDevuelta;
	}
	
	public Cobros getCobro()
	{
		return cobro;
	}

	public String getFecha()
	{
		return fecha;
	}
	
	public String getRangoHoras()
	{
		return rangoHoras;
	}
	
	public ConductorExtra añadirConductorExtra()
	{
		return null;
	}
	
}
