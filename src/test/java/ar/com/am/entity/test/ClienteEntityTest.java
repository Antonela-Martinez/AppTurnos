package ar.com.am.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.DatosAcceso;
import ar.com.am.helper.UsuarioHelper;

public class ClienteEntityTest extends UsuarioEntityTest<Cliente>{

	@Override
	protected Cliente crearUsuario() {
		return UsuarioHelper.createValidClient();
	}
	
	
	@Test
	public void testTieneDniSucces() {
		Cliente c = UsuarioHelper.createValidClient();
		assertTrue(c.tieneDni(UsuarioHelper.VALID_USER_DNI));
	}
	
	@Test
	public void testTieneDniFiler() {
		Cliente c = UsuarioHelper.createValidClient();
		assertFalse(c.tieneDni(11123123L));
	}
	
	//TEST SET EMAIL
		@Test
	    void testSetEmailValida() {
			Cliente c = UsuarioHelper.createValidClient();
		    c.setEmail(UsuarioHelper.createEmail());
		    String email = c.getEmail();
		    assertEquals(email, c.getEmail());
	    }

	    @Test
	    void testSetEmailNull() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(null);
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Cliente.ERROR_MSG_EMAIL_INVALIDO, e.getMessage());
	    	} 
	    
	    }
	    
	    @Test
	    void testSetEmailVacio() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(" ");
	    	}catch(IllegalArgumentException e){
	    		assertEquals(Cliente.ERROR_MSG_EMAIL_INVALIDO, e.getMessage());
	    	} 
	    
	    }
/*	    
	    @Test
	    void testSetEmailInvalido1() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(UsuarioHelper.createEmailInvalido(0));
	    	}catch(IllegalArgumentException e){
	    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
	    	} 
	    }
	    
	    @Test
	    void testSetEmailInvalido2() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(UsuarioHelper.createEmailInvalido(1));
	    	}catch(IllegalArgumentException e){
	    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
	    	} 
	    }
	    
	    @Test
	    void testSetEmailInvalido3() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(UsuarioHelper.createEmailInvalido(2));
	    	}catch(IllegalArgumentException e){
	    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
	    	} 
	    }
	    
	    @Test
	    void testSetEmailInvalido4() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(UsuarioHelper.createEmailInvalido(3));
	    	}catch(IllegalArgumentException e){
	    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
	    	} 
	    }
	    
	    @Test
	    void testSetEmailInvalido5() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(UsuarioHelper.createEmailInvalido(4));
	    	}catch(IllegalArgumentException e){
	    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
	    	} 
	    }
	    
	    @Test
	    void testSetEmailInvalido6() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(UsuarioHelper.createEmailInvalido(5));
	    	}catch(IllegalArgumentException e){
	    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
	    	} 
	    }
	    
	    @Test
	    void testSetEmailInvalido7() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(UsuarioHelper.createEmailInvalido(6));
	    	}catch(IllegalArgumentException e){
	    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
	    	} 
	    }
	    
	    @Test
	    void testSetEmailInvalido8() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(UsuarioHelper.createEmailInvalido(7));
	    	}catch(IllegalArgumentException e){
	    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
	    	} 
	    }
	    
	    @Test
	    void testSetEmailInvalido9() {
	    	try {
	    		Cliente c = UsuarioHelper.createValidClient();
	    		c.setEmail(UsuarioHelper.createEmailInvalido(8));
	    	}catch(IllegalArgumentException e){
	    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
	    	} 
	    }*/
	    
	    @Test
	    void testEmailsValidos() {
	        // ✅ Casos válidos
	        String[] validos = {
	            "usuario@gmail.com",
	            "mi.nombre@empresa.org",
	            "user_name123@test.co",
	            "correo+extra@dominio.info",
	            "a@b.cd"
	        };

	        for (String email : validos) {
	            assertTrue(email.matches(DatosAcceso.FORMAT_EMAIL), "Debe ser válido: " + email);
	        }
	    }
	    


	
	
}
