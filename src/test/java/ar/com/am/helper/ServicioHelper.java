package ar.com.am.helper;


import ar.com.am.clases.Servicio;

public class ServicioHelper {
	public static final String NOMBRE_SERVICIO_VALIDO = "Capping";
	public static final int PRECIO_SERVICIO_VALIDO = 16700;
	
	
	public final static Servicio createServicioValido() {
		return new Servicio(NOMBRE_SERVICIO_VALIDO,PRECIO_SERVICIO_VALIDO );
	}

}
