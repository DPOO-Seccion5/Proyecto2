package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PayU implements PasarelaPago{



	@Override
	public ResultadoBloqueo bloquearCupo(DatosPago informacionTarjeta, double monto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarTransaccion(Transaccion transaccion) {
		
		String nombreArchivo = "./Data/PayU.txt";
		registrarEnArchivo(nombreArchivo,transaccion);

	}

	@Override
	public ResultadoPago realizarPago(DatosPago informacionTarjeta, InfoPago informacion) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void registrarEnArchivo(String nombre, Transaccion transaccion)
	{
		
		ResultadoPago resultadoPago = transaccion.getResultadoPago(); 
		String resultado = resultadoPago.getMensaje();
		InfoPago datos = transaccion.getInformacion();
		double monto = datos.getMonto();
		String numCuenta = datos.getNumCuenta();
		String numTran = datos.getNumTransaccion();
		DatosPago datosP = transaccion.getTarjeta();
		String num = datosP.getNumero();
		String nombreT = datosP.getNombreTitular();
		
		try(PrintWriter writer = new PrintWriter(new FileWriter(nombre,true)))
		{
			writer.print("Resultado: "+resultado+";");
			writer.print("Datos de transaccion: "+monto+","+numCuenta+","+numTran+";");
			writer.print("Informacion de pago: "+num+","+nombreT);
			writer.println();		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
