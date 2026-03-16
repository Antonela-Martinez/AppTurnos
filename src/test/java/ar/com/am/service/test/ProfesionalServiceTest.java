package ar.com.am.service.test;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Profesional;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.servicios.ProfesionalService;

@SpringBootTest//va a ser un test que necesita todo el contexto de spring para que este atributo pueda inicializarse correctamente
@ActiveProfiles("test")
public class ProfesionalServiceTest extends UserServiceTest<Profesional, ProfesionalService>{

	@Override
	protected Profesional obtenerUsuario() {
		Profesional profesional = UsuarioHelper.createProfesionalValido();
		profesional.setNombre("Monica");
		profesional.setApellido("Diaz");
        profesional.setAcceso(UsuarioHelper.creatDatosAccesoValido());
        profesional.setTelefono(224566777);
        profesional.setIsAdmin("PROFESIONAL");
        
        return profesional;
	}
}
