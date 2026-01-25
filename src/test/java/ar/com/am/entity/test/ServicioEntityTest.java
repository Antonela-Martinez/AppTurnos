package ar.com.am.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.com.am.clases.Servicio;
import ar.com.am.clases.Usuario;
import ar.com.am.helper.ServicioHelper;

public class ServicioEntityTest {
	
	@Test
	public void testServicioValido() {
		Servicio s = ServicioHelper.createServicioValido();
		s.setNombre(ServicioHelper.NOMBRE_SERVICIO_VALIDO);
		String nombre = s.getNombre();
		assertEquals(s.getNombre(), nombre);
	}
	
	 @Test
	 public void testSetNombreNull() {
	    	try {
	    		Servicio s = ServicioHelper.createServicioValido();
	    		s.setNombre(null);
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Servicio.ERROR_MSG_NOMBRE_EMPTY_SERVICIO, e.getMessage());
	    	}
	    }
	
	
	 @Test
	 public void testSetNombreVacio() {
	    	try {
	    		Servicio s = ServicioHelper.createServicioValido();
	    		s.setNombre(" ");
	    	}catch(IllegalArgumentException e ){
	    		assertEquals(Servicio.ERROR_MSG_NOMBRE_EMPTY_SERVICIO, e.getMessage());
	    	}
	    }
	 
	 @Test
	 public void testSetNombreMuyLargo() {
	    	try {
	    		Servicio s = ServicioHelper.createServicioValido();
	    		String nombreLargo = "A".repeat(51);
	    		s.setNombre(nombreLargo);
	    		
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Usuario.ERROR_MESSAGE_MAX_CARACTER, e.getMessage());
	    	}
	    }
	 
	 @Test
	 public void testSetPrecioCero() {
	    	try {
	    		Servicio s = ServicioHelper.createServicioValido();
	    		int PrecioInvalido  = Servicio.CERO;
	    		s.setPrecio(PrecioInvalido);
	    		
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Servicio.ERROR_MSG_PRECIO_INVALIDO, e.getMessage());
	    	}
	    }
	 
	 @Test
	 public void testSetPrecioMuyLargo() {
	    	try {
	    		Servicio s = ServicioHelper.createServicioValido();
	    		int PrecioInvalido  = 1+Servicio.NUMERO_MAX;
	    		s.setPrecio(PrecioInvalido);
	    		
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Servicio.ERROR_MSG_PRECIO_INVALIDO, e.getMessage());
	    	}
	    }
	 
	 

}
