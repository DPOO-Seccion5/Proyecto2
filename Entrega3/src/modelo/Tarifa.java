package modelo;

public class Tarifa {
	
	
	private double tarifaTempAlta;
	
	private double tarifaTempBaja;
	
	private double tarifaOtraSede;
	
	private double tarifaConductorAdicional;

	private double tarifaPorcentajePrima;
	
	
	public Tarifa(double laTarifaTempAlta, double laTarifaTempBaja, double laTarifaOtraSede, double laTarifaCondutorAdicional, double laTarifaProcentajePrima)
	{
		this.tarifaTempAlta = laTarifaTempAlta;
		this.tarifaTempBaja = laTarifaTempBaja;
		this.tarifaOtraSede = laTarifaOtraSede;
		this.tarifaConductorAdicional = laTarifaCondutorAdicional;
		this.tarifaPorcentajePrima= laTarifaProcentajePrima;
		
	}
	
	
	public double getTarifaAlta()
	{
		return tarifaTempAlta;
	}
	
	public double getTarifaBaja()
	{
		return tarifaTempBaja;
	}
	
	public double getTarifaOtraSede()
	{
		return tarifaOtraSede;
	}
	
	public double getTarifaConductor()
	{
		return tarifaConductorAdicional;
	}
	public double getTarifaPorcentajePrima()
	{
		return tarifaPorcentajePrima;
	}

}
