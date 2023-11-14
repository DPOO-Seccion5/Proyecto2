package modelo;

public class Disponibilidad {
	
	private boolean alquilado;
	
	private String ubicacion;
	
	private String fechaDevolucion;
	
	private String lugarDevolucion;
	
	private String fechaDisponibilidad;
	
	
	
	public Disponibilidad(boolean estaAlquilado, String laUbicacion, String laFechaDevolucion, String elLugarDevolucion, String laFechaDisponibilidad)
	{
		this.alquilado = estaAlquilado;
		this.ubicacion = laUbicacion;
		this.fechaDevolucion = laFechaDevolucion;
		this.lugarDevolucion = elLugarDevolucion;
		this.fechaDisponibilidad = laFechaDisponibilidad;
		
	}
	
	public boolean getIfAlquilado()
	{
		return alquilado;
	}
	
	public String getUbicacion()
	{
		return ubicacion;
	}
	
	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public void setLugarDevolucion(String lugarDevolucion) {
		this.lugarDevolucion = lugarDevolucion;
	}

	public void setFechaDisponibilidad(String fechaDisponibilidad) {
		this.fechaDisponibilidad = fechaDisponibilidad;
	}



	public String getFechaDevolucion()
	{
		return fechaDevolucion;
	}

	public String getLugarDevolucion()
	{
		return lugarDevolucion;
	}
	
	public String getFechaDisponibilidad()
	{
		return fechaDisponibilidad;
	}

}
