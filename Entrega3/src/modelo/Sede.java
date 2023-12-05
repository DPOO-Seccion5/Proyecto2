package modelo;

import java.util.List;

public class Sede {
	
	private String nombre;
	
	private String ubicacion;
	
	private String horaDeAtencion;
	
	private String[] empleados;
	
	
	
	public Sede(String elNombre, String laUbicacion, String laHoraAtencion, String[] losEmpleados) 
	{
		this.nombre = elNombre;
		this.ubicacion = laUbicacion;
		this.horaDeAtencion = laHoraAtencion;
		this.empleados = losEmpleados;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getUbicacion()
	{
		return ubicacion;
	}
	
	public String getHoraDeAtencion()
	{
		return horaDeAtencion;
	}
	
	public String[] getEmpleados()
	{
		return empleados;
	}
	
	public void setNombre(String nuevoNombre)
	{
		this.nombre = nuevoNombre;
		
	}
	
	public void setUbicacion(String nuevaUbicacion)
	{
		this.ubicacion = nuevaUbicacion;
	}
	
	public void setHoraAtencion(String hora)
	{
		this.horaDeAtencion = hora;
	}

}
