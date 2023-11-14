package modelo;

import java.util.List;

import procesamiento.Compañia;

public class AdministradorGeneral {
	
	private Compañia compañia;
	
	
	public AdministradorGeneral(Compañia laCompañia)
	{
		this.compañia = laCompañia;
	}
	
	
	public void agregarVehiculo(Compañia compañia, Vehiculo vehiculo)
	{
		Inventario inventario = compañia.getInventario();
		List<Vehiculo> listaVehiculos = inventario.getVehiculos();
		inventario.añadirVehiculo(listaVehiculos, vehiculo);
	}
	
	public void modificarNombreSede(String nombreViejo, String nuevoNombre)
	{
		List<Sede> sedes = compañia.getSedes();
		for (Sede sede : sedes) 
		{
			String nombre = sede.getNombre();
			if (nombre.equals(nombreViejo))
			{
				sede.setNombre(nuevoNombre);
			}
			
		}
	}
	
	public void modificarUbicacionSede(String ubicacionVieja, String nuevaUbicacion)
	{
		List<Sede> sedes = compañia.getSedes();
		for (Sede sede : sedes) 
		{
			String ubicacion = sede.getUbicacion();
			if (ubicacion.equals(ubicacionVieja))
			{
				sede.setUbicacion(nuevaUbicacion);
			}
			
		}
	}

	
	public void añadirSegurosAlCobro()
	{
		
	}
	
	public void modificarHoraAtencion(String nombreSede, String nuevaHora)
	{
		List<Sede> sedes = compañia.getSedes();
		for (Sede sede : sedes) 
		{
			String nombre = sede.getNombre();
			if (nombre.equals(nombreSede))
			{
				sede.setHoraAtencion(nuevaHora);
			}
			
		}
		
	}
}
