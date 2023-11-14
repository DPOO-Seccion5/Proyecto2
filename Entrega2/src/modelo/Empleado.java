package modelo;

public class Empleado extends Usuario{
	
	private String nombre;
	
	private String username;
	
	private String password;
	
	private String numeroID;
	
	private String fechaNacimiento;
	
	private String nacionalidad;
	
	
	public Empleado(String elNombre,String elUsername, String elPassword, String elNumeroID, String laNacionalidad, String laFechaNacimiento)
	{
		this.nombre = elNombre;
		this.username = elUsername;
		this.password = elPassword;
		this.numeroID = elNumeroID;
		this.fechaNacimiento = laFechaNacimiento;
		this.nacionalidad = laNacionalidad;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}


	@Override
	public String getNumeroID() {
		// TODO Auto-generated method stub
		return numeroID;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	
	public void actualizarDatosCarro()
	{
		
	}
	
	public void registrarConductoresAd()
	{
		
	}
	
	public Reserva getReserva()
	{
		return null;
	}
	
	public int getConductoresAdicionales()
	{
		return (Integer) null;
	}
	
	public double getCobroTotal()
	{
		return (Double) null;
	}

	@Override
	public String getNacionalidad() {
		// TODO Auto-generated method stub
		return nacionalidad;
	}

	@Override
	public String getFechaNacimiento() {
		// TODO Auto-generated method stub
		return fechaNacimiento;
	}
	
	
	
	
	

}
