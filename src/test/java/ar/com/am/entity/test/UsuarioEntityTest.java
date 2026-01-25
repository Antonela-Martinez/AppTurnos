package ar.com.am.entity.test;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import ar.com.am.clases.Usuario;



public abstract class UsuarioEntityTest<T extends Usuario> {
	
	
	//Metodo abstracto que cada clase hija va a usar
	protected abstract T crearUsuario();
	
//TEST SET DNI
	@Test
	public void testSetDniValido() {
	 	Usuario usuario = crearUsuario();
		usuario.setDni(43777987L);
		assertEquals(43777987L, usuario.getDni());
	 		//Usuario usuario = crearUsuario();
	 		//assertEquals(UsuarioHelper.createValidClient(), usuario.getDni());
	}

	@Test
	public void testSetDniNull() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setDni(null);
	    		
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Usuario.ERROR_MESSAGE_DNI, e.getMessage());
	    	}
	}
	    
	@Test
	public void testSetDniMuyCorto() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setDni(999999L);// menor a 1.000.000
	    		
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Usuario.ERROR_MESSAGE_DNI,e.getMessage());
	    	}  
	}

	@Test
	public void testSetDniMuyLargo() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setDni(100000000L); // mayor a 99.999.999
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Usuario.ERROR_MESSAGE_DNI,e.getMessage());
	    	}
	}


//Test setNombre
	 @Test
	 public void testNombreValido() {
	        Usuario usuario = crearUsuario();
	        usuario.setNombre("Antonela");
	        assertEquals("Antonela", usuario.getNombre());
	    }
	    
	 @Test
	 public void testSetNombreNull() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setNombre(null);
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Usuario.ERROR_MESSAGE_EMPTY, e.getMessage());
	    	}
	    }
	
	 @Test
	 public void testSetNombreVacio() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setNombre("   ");
	    	}catch(IllegalArgumentException e ){
	    		assertEquals(Usuario.ERROR_MESSAGE_EMPTY, e.getMessage());
	    	}
	    }
	
	 @Test
	 public void testSetNombreMuyLargo() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		String nombreLargo = "A".repeat(51);
	    		usuario.setNombre(nombreLargo);
	    		
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Usuario.ERROR_MESSAGE_MAX_CARACTER, e.getMessage());
	    	}
	    }
    
    
//Test setApellido
	 @Test
	 public void testApellidoValido() {
	        Usuario usuario = crearUsuario();
	        usuario.setApellido("Martinez");
	        assertEquals("Martinez", usuario.getApellido());
	    }
	    
	 @Test
	 public void testSetApellidoNull() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setApellido(null);
	    		
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Usuario.ERROR_MESSAGE_EMPTY, e.getMessage());
	    	}
	    }
	    
	 @Test
	 public void testSetApellidoVacio() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setApellido("   ");
	    		
	    	}catch(IllegalArgumentException e) {
	    		assertEquals(Usuario.ERROR_MESSAGE_EMPTY, e.getMessage());
	    	}
	    }
	    
	 @Test
	 public void testSetApellidoMuyLargo() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		String apellidoLargo = "A".repeat(50);
	    		usuario.setApellido(apellidoLargo);
	    		
	    	}catch(IllegalArgumentException e) {
	    		assertEquals(Usuario.ERROR_MESSAGE_MAX_CARACTER, e.getMessage());
	    	}
	    }
	    
	    
//test setTelefono
	 @Test
	 public void testSetTelefonoValido() {
	    	
	        Usuario usuario = crearUsuario();
	        usuario.setTelefono(223456789L); // 9 dígitos
	        assertEquals(223456789L, usuario.getTelefono());
	    }
	    
	 @Test
	 public void testSetTelefonoNegativo() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setTelefono(-1234567L);
	    		
	    	}catch(IllegalArgumentException e) {
	    		assertEquals(Usuario.ERROR_MESSAGE_EMPTY, e.getMessage());
	    	}
	 }
	    
	 @Test
	 public void testSetTelefonoCero() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setTelefono(0);
	    		
	    	}catch(IllegalArgumentException e) {
	    	assertEquals(Usuario.ERROR_MESSAGE_EMPTY, e.getMessage());
	    	}
	 }
	    
	 @Test
	 public void testSetTelefonoMuyCorto() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setTelefono(123456L); // 6 dígitos
	    		
	    	}catch(IllegalArgumentException e) {
	    		assertEquals(Usuario.ERROR_MESSAGE_TELEFONO, e.getMessage());
	    	}
	 }
	
	 @Test
	 public void testSetTelefonoMuyLargo() {
	    	try {
	    		Usuario usuario = crearUsuario();
	    		usuario.setTelefono(1234567890123456L); // 16 dígitos
	    		
	    	}catch(IllegalArgumentException e) {
	    		assertEquals(Usuario.ERROR_MESSAGE_TELEFONO, e.getMessage());
	    	}
	 }
	
	

	
}