package ar.com.am.entity.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.am.clases.Usuario;


public abstract class UsuarioEntityTest<T extends Usuario> {
	
	//Metodo abstracto que cada clase hija va a usar
	protected abstract T crearUsuario();
	
//TEST SET DNI
	 	@Test
	    void testSetDniValido() {
	        Usuario usuario = crearUsuario();
	        usuario.setDni(43777987L);
	        assertEquals(43777987L, usuario.getDni());
	    }

	    @Test
	    void testSetDniNull() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setDni(null));
	    }
	    
	    @Test
	    void testSetDniMuyCorto() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setDni(999999L)); // menor a 1.000.000
	    }

	    @Test
	    void testSetDniMuyLargo() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setDni(100000000L)); // mayor a 99.999.999
	    }


//Test setNombre
	    @Test
	    void testNombreValido() {
	        Usuario usuario = crearUsuario();
	        usuario.setNombre("Antonela");
	        assertEquals("Antonela", usuario.getNombre());
	    }
	    
	    @Test
	    void testSetNombreNull() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setNombre(null));
	    }
	
	    @Test
	    void testSetNombreVacio() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setNombre("   "));
	    }
	
	    @Test
	    void testSetNombreMuyLargo() {
	        Usuario usuario = crearUsuario();
	        String nombreLargo = "A".repeat(51);
	        assertThrows(IllegalArgumentException.class, () -> usuario.setNombre(nombreLargo));
	    }
    
    
//Test setApellido
	    @Test
	    void testApellidoValido() {
	        Usuario usuario = crearUsuario();
	        usuario.setApellido("Martinez");
	        assertEquals("Martinez", usuario.getApellido());
	    }
	    
	    @Test
	    void testSetApellidoNull() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setApellido(null));
	    }
	    
	    @Test
	    void testSetApellidoVacio() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setApellido("   "));
	    }
	    
	    @Test
	    void testSetApellidoMuyLargo() {
	        Usuario usuario = crearUsuario();
	        String apellidoLargo = "A".repeat(50);
	        assertThrows(IllegalArgumentException.class, () -> usuario.setApellido(apellidoLargo));
	    }
	    
	    
//test setTelefono
	    @Test
	    void testSetTelefonoValido() {
	        Usuario usuario = crearUsuario();
	        usuario.setTelefono(223456789L); // 9 dígitos
	        assertEquals(223456789L, usuario.getTelefono());
	    }
	    
	    @Test
	    void testSetTelefonoNegativo() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setTelefono(-1234567L));
	    }
	    
	    @Test
	    void testSetTelefonoCero() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setTelefono(0));
	    }
	    
	    @Test
	    void testSetTelefonoMuyCorto() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setTelefono(123456L)); // 6 dígitos
	    }
	
	    @Test
	    void testSetTelefonoMuyLargo() {
	        Usuario usuario = crearUsuario();
	        assertThrows(IllegalArgumentException.class, () -> usuario.setTelefono(1234567890123456L)); // 16 dígitos
	    }
	
	
// --- tieneDni ---
	    @Test
	    void testTieneDniValido() {
	        Usuario usuario = crearUsuario();
	        usuario.setDni(43777987L);
	        assertTrue(usuario.tieneDni(43777987L));
	    }
	
	    @Test
	    void testTieneDniInvalido() {
	        Usuario usuario = crearUsuario();
	        usuario.setDni(43777987L);
	        assertFalse(usuario.tieneDni(12345678L));
	    }
	
	    @Test
	    void testTieneDniNull() {
	        Usuario usuario = crearUsuario();
	        assertFalse(usuario.tieneDni(43777987L));
	    }
	    
//---esDniValido---
	    
	    @Test
	    void testEsDniValido() {
	    	Usuario usuario = crearUsuario();
	    	usuario.setDni(43777987L);
	    	assertTrue(usuario.esDniValido());
	    }
	    
	    
	    @Test
	    void test_TieneDniInvalido() {
	    	Usuario usuario = crearUsuario();
	    	usuario.setDni(4377L);
	    	assertFalse(usuario.esDniValido());
	    }
	    
	    @Test
	    void testEsDniValidoNull() {
	        Usuario usuario = crearUsuario();
	        assertFalse(usuario.esDniValido());
	    }

//TieneNombreValido
	    @Test
	    void testTieneNombreValidoCorrecto() {
	        Usuario usuario = crearUsuario();
	        usuario.setNombre("Antonela");
	        assertTrue(usuario.tieneNombreValido());
	    }

	    @Test
	    void testTieneNombreValidoIncorrecto() {
	        Usuario usuario = crearUsuario();
	        usuario.setNombre("   "); // vacío
	        assertFalse(usuario.tieneNombreValido());
	    }
	    
	    @Test
	    void testTieneNombreValidoNull() {
	        Usuario usuario = crearUsuario();
	        assertFalse(usuario.tieneNombreValido());
	    }








	@Test
	public abstract void testTieneDniSucces();
	
	@Test
	public abstract void testTieneDniFailure();
	
	@Test
	public abstract void testTieneDni();


	
}