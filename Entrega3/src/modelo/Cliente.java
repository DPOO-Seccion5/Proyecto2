package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	
	private String nombre;
	
	private String numID; 
	
	private String fechaNacimiento;
	
	private String nacionalidad;
	
	private String username;
	
	private String password;
	
	private DatosPago datosMetodoPago;
	
	private Reserva reserva;
	
	private DatosLicencia licencia;
	
	
	
	
	public Cliente(String elNombre, String elNumID,String laFechaNacimiento, String laNacionalidad, String elUsername, String elPassword, DatosLicencia laLicencia, DatosPago losDatosMetodoPago, Reserva laReserva)
	{
		this.nombre = elNombre;
		this.numID = elNumID;
		this.fechaNacimiento = laFechaNacimiento;
		this.nacionalidad = laNacionalidad;
		this.username = elUsername;
		this.password = elPassword;
		this.licencia = laLicencia;
		this.datosMetodoPago = losDatosMetodoPago;
		this.reserva = laReserva;
	}
	
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getFechaNacimiento()
	{
		return fechaNacimiento;
	}
	
	public String getNacionalidad()
	{
		return nacionalidad;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public DatosPago getDatosMetodoPago()
	{
		return datosMetodoPago;
	}
	
	public Reserva getReserva()
	{
		return reserva;
	}
	
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	public DatosLicencia getLicencia()
	{
		return licencia;
	}
	
	



	public String getNumID() {
		return numID;
	}


	public void setNumID(String numID) {
		this.numID = numID;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setDatosMetodoPago(DatosPago datosMetodoPago) {
		this.datosMetodoPago = datosMetodoPago;
	}


	public void setLicencia(DatosLicencia licencia) {
		this.licencia = licencia;
	}


	@Override
	public String getNumeroID() {
		// TODO Auto-generated method stub
		return numID;
	}
	

}
