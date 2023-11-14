package modelo;

public class Categoria {
	
	private String categoria;
	
	private double precio;
	
	private String tamaño;
	
	private Tarifa tarifa;
	
	
	public Categoria(String laCategoria, double elPrecio, String elTamaño, Tarifa laTarifa)
	{
		this.categoria = laCategoria;
		this.precio = elPrecio;
		this.tamaño = elTamaño;
		this.tarifa = laTarifa;
		
	}
	
	
	
	
	public String getCategoria()
	{
		return categoria;
	}
	
	public double getPrecio()
	{
		return precio;
	}
	
	public String getTamaño()
	{
		return tamaño;
	}
	
	public Tarifa getTarifa()
	{
		return tarifa;
	}
	
	
}
