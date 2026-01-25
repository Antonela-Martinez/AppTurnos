package ar.com.am.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.am.clases.DatosAcceso;
import ar.com.am.helper.UsuarioHelper;

public class DatosAccesoEntityTest {
	
	
//TEST SET CLAVE
 	@Test
    void testSetClaveValida() {
 		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
	    ac.setClave(UsuarioHelper.createClave());
	    assertEquals(UsuarioHelper.createClave(), ac.getclave());
    }

    @Test
    void testSetClaveNull() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setClave(null);
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_EMPTY_EMAIL, e.getMessage());
    	} 
    }
    
    @Test
    void testSetClaveVacia() {
    	try {
    		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setClave("   ");
    	}catch(IllegalArgumentException e ){
    		assertEquals(DatosAcceso.MSG_EMPTY_EMAIL, e.getMessage());
    	}
    }
    
    @Test
    void testSetClaveMuyCorta() {
    	try {
    		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setClave(UsuarioHelper.createClaveCorta());// menor a 8 caracteres	
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.ERROR_MSG_MIN_CARACTER,e.getMessage());
    	}
        
    }

    @Test
    void testSetClaveMuyLarga() {
    	try {
    		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setClave(UsuarioHelper.createClaveLarga()); // mayor a 25	
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.ERROR_MSG_MAX_CARACTER,e.getMessage());
    	}
        
    }
    
    @Test
    void testSetClaveSinMayuscula() {
    	try {
    		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setClave(UsuarioHelper.createClaveSinMayuscula()); 
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.ERROR_MSG_SIN_MAYUSCULA,e.getMessage());
    	} 
    }
    
    @Test
    void testSetClaveSinNumero() {
    	try {
    		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setClave(UsuarioHelper.createClaveSinNumero()); 	
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.ERROR_MSG_SIN_NUM,e.getMessage());
    	}   
    }
    
    @Test
    void testSetClaveSinCaracter() {
    	try {
    		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setClave(UsuarioHelper.createClaveSinCaracter()); // mayor a 25	
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.ERROR_MSG_SIN_MAYUSCULA,e.getMessage());
    	}   
    }
    
  //TEST SET EMAIL
	@Test
    void testSetEmailValida() {
 		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
	    ac.setEmailUsr(UsuarioHelper.createEmail());
	    String email = ac.getEmailUsr();
	    assertEquals(email, ac.getEmailUsr());
    }

    @Test
    void testSetEmailNull() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(null);
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_EMPTY_EMAIL, e.getMessage());
    	} 
    
    }
    
    @Test
    void testSetEmailVacio() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(" ");
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_EMPTY_EMAIL, e.getMessage());
    	} 
    
    }
    
    @Test
    void testSetEmailInvalido1() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(UsuarioHelper.createEmailInvalido(0));
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
    	} 
    }
    
    @Test
    void testSetEmailInvalido2() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(UsuarioHelper.createEmailInvalido(1));
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
    	} 
    }
    
    @Test
    void testSetEmailInvalido3() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(UsuarioHelper.createEmailInvalido(2));
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
    	} 
    }
    
    @Test
    void testSetEmailInvalido4() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(UsuarioHelper.createEmailInvalido(3));
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
    	} 
    }
    
    @Test
    void testSetEmailInvalido5() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(UsuarioHelper.createEmailInvalido(4));
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
    	} 
    }
    
    @Test
    void testSetEmailInvalido6() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(UsuarioHelper.createEmailInvalido(5));
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
    	} 
    }
    
    @Test
    void testSetEmailInvalido7() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(UsuarioHelper.createEmailInvalido(6));
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
    	} 
    }
    
    @Test
    void testSetEmailInvalido8() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(UsuarioHelper.createEmailInvalido(7));
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
    	} 
    }
    
    @Test
    void testSetEmailInvalido9() {
    	try {
     		DatosAcceso ac = UsuarioHelper.creatDatosAccesoValido();
    		ac.setEmailUsr(UsuarioHelper.createEmailInvalido(8));
    	}catch(IllegalArgumentException e){
    		assertEquals(DatosAcceso.MSG_INVALID_FORMAT_EMAIL, e.getMessage());
    	} 
    }
    
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
    
 
    
   /* @Test
    void testEmailInvalidos() {
    	// ❌ Casos inválidos
        String[] invalidos = {
            "@gmail.com",
            "usuario@.com",
            "usuario@gmail",
            "usuario@gmail.c",
            "usu@rio@gmail.com",
            "usuario@dominio..com",
            "usuario@dominio_com",
            "usuario gmail.com",
            "usuario@dominio.c0m"
        };

        for (String email : invalidos) {
            assertFalse(email.matches(DatosAcceso.FORMAT_EMAIL), "Debe ser inválido: " + email);
        }
    }*/
        
}


