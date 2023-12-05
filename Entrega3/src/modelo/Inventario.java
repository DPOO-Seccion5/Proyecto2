package modelo;

import java.util.List;

public class Inventario {
	
	
	private List<Vehiculo> vehiculos;
	
	public Inventario(List<Vehiculo> losVehiculos)
	{
		this.vehiculos = losVehiculos;
	}
	
	
	public List<Vehiculo> getVehiculos()
	{
		return vehiculos;
	}
	
	public void añadirVehiculo(List<Vehiculo> vehiculos, Vehiculo nuevoVehiculo) 
	{
		vehiculos.add(nuevoVehiculo);
		
	}
}
