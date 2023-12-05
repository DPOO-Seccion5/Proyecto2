package modelo;

import java.util.List;

public class Vehiculo {
	
	private String nombre;

	private String marca;
	
	private String placa;
	
	private String modelo;
	
	private String color;
	
	private String tipoTransmision;
	
	
	private Categoria categoria;
	
	private Disponibilidad disponibilidad;
	
	
	public Vehiculo(String elNombre,String laMarca, String laPlaca, String elModelo, String elColor, String elTipoTransmision, Categoria laCategoria, Disponibilidad laDisponibilidad) 
	{
		this.nombre = elNombre;
		this.marca = laMarca;
		this.placa = laPlaca;
		this.modelo = elModelo;
		this.color = elColor;
		this.tipoTransmision = elTipoTransmision;
		this.categoria = laCategoria;
		this.disponibilidad = laDisponibilidad;
	
	}
	
	public Disponibilidad getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Disponibilidad disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setTipoTransmision(String tipoTransmision) {
		this.tipoTransmision = tipoTransmision;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getMarca()
	{
		return marca;
	}
	
	public String getPlaca()
	{
		return placa;
	}
	
	public String getModelo()
	{
		return modelo;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String getTipoTransmision()
	{
		return tipoTransmision;
	}
	
	
	public Categoria getCategoria()
	{
		return categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
