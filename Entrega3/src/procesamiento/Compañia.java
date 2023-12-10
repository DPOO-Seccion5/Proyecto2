package procesamiento;

import java.io.IOException;
import java.util.ArrayList;
import procesamiento.Loader;

import modelo.*;
import java.util.List;
import java.util.Map;


public class Compañia {
	
	
	private Inventario inventario;
	
	private List<Sede> sedes;
	
	private List<Cliente> clientes;
	
	private List<Empleado> empleados;
	
	private List<PasarelaPago> pasarelas;
	

	
	
	public Compañia(Inventario elInventario, List<Sede> lasSedes, List<Cliente> losClientes, List<Empleado> losEmpleados, List<PasarelaPago> lasPasarelas)
	{
		this.inventario = elInventario;
		this.sedes = lasSedes;
		this.clientes = losClientes;
		this.empleados = losEmpleados;
		this.pasarelas = lasPasarelas;
	}
	
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public List<PasarelaPago> getPasarelas() {
		return pasarelas;
	}


	public void setPasarelas(List<PasarelaPago> pasarelas) {
		this.pasarelas = pasarelas;
	}


	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}


	public void setSedes(List<Sede> sedes) {
		this.sedes = sedes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public Inventario getInventario()
	{
		return inventario;
	}
	
	public List<Sede> getSedes()
	{
		return sedes;
	}
	
	public List<Cliente> getClientes()
	{
		return clientes;
	}
	
	
	
	public Cliente logIn(String username, String password)
	{
		Cliente cliente = null;
		
			
			for(Cliente x : clientes)
			{
				String user = x.getUsername();
				String pass = x.getPassword();
				
			
				if ((username.equals(user)) && (password.equals(pass)))
				{
					
					cliente = x;
				}
			}
		return cliente;
		
	}
	
	
	public Empleado logInEmpleado(String username, String password)
	{
		Empleado empleado = null;
		
		
		for(Empleado y : empleados)
		{
			String user = y.getUsername();
			String pass = y.getPassword();
			
			if ((username.equals(user)) && (password.equals(pass)))
			{
				empleado = y;
			}
				
		}
		
		return empleado;
	}
	
	
	
	
	
	public Cliente crearCliente(String nombre,String numID, String fechaNacimiento, String nacionalidad, String username, String password, String numeroLicencia, String paisExpedicion,String numeroTarjeta, String fechaVencimiento, String nombreTitular, String cvc)
	{
		DatosLicencia licencia = new DatosLicencia(numeroLicencia, paisExpedicion, fechaNacimiento);
		DatosPago tarjeta = new DatosPago(numeroTarjeta, fechaVencimiento,nombreTitular,cvc);
		Cliente cliente = new Cliente(nombre,numID, fechaNacimiento, nacionalidad, username, password, licencia,tarjeta,null);
		clientes.add(cliente);
		Loader.saveCliente(nombre, numID, fechaNacimiento,nacionalidad, username, password,numeroLicencia, paisExpedicion, numeroTarjeta, fechaVencimiento,  nombreTitular, cvc);
		return cliente;
		
	}
	

	

	
	public Empleado crearEmpleado(String nombre, String username, String password, String numID, String nacionalidad, String fechaNacimiento)
	{
		Empleado empleado = new Empleado(nombre,username,password,numID,nacionalidad,fechaNacimiento);
		empleados.add(empleado);
		Loader.saveEmpleado(nombre,username,password,numID,nacionalidad,fechaNacimiento);
		
		return empleado;
		
	}
	
	
	
	public double crearReserva(Cliente cliente, String categoria, String sedeRecogida, String sedeDevuelta,Cobros cobro,String fecha, String rangoHor, String temporada, ArrayList<ConductorExtra> conductoresExtra)
	{
		double precio = 0.0;
		double temp = 0.0;
		double cambioSede = 0.0;
		double conExtra = 0.0;
		for (Vehiculo carro : inventario.getVehiculos())
		{
			Categoria catCarro = carro.getCategoria();
			System.out.println(carro);
			if (catCarro.getCategoria().equals(categoria))
			{
				precio = catCarro.getPrecio();
				Tarifa tarifa = catCarro.getTarifa();
				if (temporada.equals("Alta"))
				{
					temp = tarifa.getTarifaAlta();
					precio = precio + temp;
				}
				else if (temporada.equals("Baja"))
				{
					precio = tarifa.getTarifaBaja();
				}
				if(sedeRecogida.equals(sedeDevuelta))
				{
					cambioSede = 0;
				}
				else

				{
					cambioSede = tarifa.getTarifaOtraSede();
				}
				if(conductoresExtra.size() > 0)
				{
					double precioCon = tarifa.getTarifaConductor();
					for (int i = 0; i <= conductoresExtra.size(); i++)
					{
						conExtra =+ precioCon;
					}
				}	
			}
		}
		precio = precio+conExtra;
		
		precio = precio + cambioSede;
		
		Reserva reserva = new Reserva(categoria, sedeRecogida, sedeDevuelta, cobro, fecha, rangoHor, conductoresExtra);
		
		cliente.setReserva(reserva);
		
		Loader.editClientes(reserva,cliente);
		
		
		
		return precio;
		
	}
	
	
	public void crearTransaccion(DatosPago infoTarjeta, String mensaje, boolean resultado, double monto, String nomCuenta, String numTransaccion)
	{
		ResultadoPago resultadoP = new ResultadoPago(resultado,mensaje);
		
		
		
	}
	
	public String nombreCarro(String categoria)
	{
		String nombreCarro = "No hay disponibles";
		for(Vehiculo carro : (inventario.getVehiculos()))
		{
			Categoria cat = carro.getCategoria();
			String nombre = cat.getCategoria();
			Disponibilidad dis = carro.getDisponibilidad();
			boolean alqui = dis.getIfAlquilado();
			
			if(nombre.equals(categoria) && (alqui!=false))
			{
				
				System.out.println(nombre);
				nombreCarro = carro.getNombre();	
			}
		}
		for (Vehiculo carro : (inventario.getVehiculos()))
		{
			if(nombreCarro.equals(carro.getNombre())) 
			{
				Disponibilidad dis = carro.getDisponibilidad();
				dis.setAlquilado(false);
				Loader.editCarro(carro, false);
			}
		}
		
		return nombreCarro;
		
	}
	

	public void modificarReserva(Cliente cliente, String modificacion, String opcion)
	{
		Reserva reserva = cliente.getReserva();
		
		if (opcion.equals("1"))
		{
			reserva.setSedeRecogida(modificacion);
		}
		else if (opcion.equals("2"))
		{
			reserva.setSedeDevuelta(modificacion);
		}
		else if (opcion.equals("3"))
		{
			reserva.setFecha(modificacion);
		}
		else if (opcion.equals("4"))
		{
			reserva.setRangoHoras(modificacion);
		}
		
	}
	
	public Vehiculo buscarVehiculo(String placa)
	{
		
		
		Vehiculo carro = null;
		for(Vehiculo vehiculo : inventario.getVehiculos())
		{
			if(vehiculo.getPlaca().equals(placa))
			{
				carro = vehiculo;
			}
		}
		if (carro == null)
		{
			System.out.println("No se encontro el vehiculo");
		}
		
		
		
		return carro;
	}
	
	public ArrayList<String> listaVehiculosPorSede(String sede){
		ArrayList<String> vehiculos = new ArrayList();
		for(Vehiculo vehiculo : inventario.getVehiculos()) {
			
			Disponibilidad disp=vehiculo.getDisponibilidad();
			String ubicacion=disp.getUbicacion();
			Boolean disponible = disp.getIfAlquilado();
			
			
			if(ubicacion.equals(sede) && disponible.equals(true)) {
				String nombre = vehiculo.getNombre();
				String placa = vehiculo.getPlaca();
				Categoria categoria = vehiculo.getCategoria();
				String categoriaOg = categoria.getCategoria();
				Double precio = categoria.getPrecio();
				String precioOg = String.valueOf(precio);
				System.out.println(nombre+" Placa: "+placa+" Categoria: "+categoriaOg+" Precio base: "+precioOg);
				
				vehiculos.add(nombre+" Placa: "+placa+" Categoria: "+categoriaOg+" Precio base: "+precioOg);
			}
			
		}
		return vehiculos;
	}
	
	public String conocerDisponibilidad(Vehiculo vehiculo)
	{
		String respuesta = "";
		Disponibilidad disponibilidad = vehiculo.getDisponibilidad();
		
		boolean alquilado = disponibilidad.getIfAlquilado();
		
		String ubicacion = disponibilidad.getUbicacion();
		
		if(alquilado == true)
		{
			respuesta = "Esta alquilado y su ubicacion es: "+ubicacion;
		}
		else if(alquilado == false)
		{
			respuesta = "No esta alquilado y su ubicacion es: "+ubicacion;
		}
		
		return respuesta;
		
	}
	
	public void crearVehiculo(String nombre, String marca, String placa, String modelo, String color, String tipoTrans, String ubicacion, String laCategoria, double precio, String tamaño, double tempAlta, double tempBaja, double otraSede, double conAd)
	{
		Tarifa tarifa = new Tarifa(tempAlta, tempBaja, otraSede, conAd);
		
		Categoria categoria = new Categoria(laCategoria, precio, tamaño, tarifa);
		
		Disponibilidad disp = new Disponibilidad(false, ubicacion, null, null, null);
		
		Vehiculo vehiculo = new Vehiculo(nombre, marca, placa, modelo, color, tipoTrans, categoria, disp);
		
		ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) inventario.getVehiculos();
		
		vehiculos.add(vehiculo);
		
		Loader.addCarros(nombre, vehiculo);
	}

	public boolean eliminarVehiculo(String placa) throws IOException
	{
		boolean respuesta = false;
		ArrayList<Vehiculo> lista = (ArrayList<Vehiculo>) inventario.getVehiculos();
		
		for (Vehiculo vehiculo : lista)
		{
			if(placa.equals(vehiculo.getPlaca()))
			{
				
				respuesta = true;
			}
		}
		Loader.deleteCarros(placa);
		
		return respuesta;
	}
	
}
