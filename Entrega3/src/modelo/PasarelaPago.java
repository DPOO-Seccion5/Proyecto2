package modelo;

public interface PasarelaPago {
	
	 ResultadoPago realizarPago(DatosPago informacionTarjeta, InfoPago informacion);
	 ResultadoBloqueo bloquearCupo(DatosPago informacionTarjeta, double monto);
	 void registrarTransaccion(Transaccion transaccion);

}
