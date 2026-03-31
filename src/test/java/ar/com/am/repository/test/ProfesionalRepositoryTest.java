package ar.com.am.repository.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Profesional;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.repositorios.ProfesionalRepository;

@SpringBootTest
@ActiveProfiles(value = "test")
public class ProfesionalRepositoryTest extends UserRepositoryTest<Profesional,ProfesionalRepository> {
	
	protected Profesional obtenerUsuario() {
		Profesional profesional = UsuarioHelper.createProfesionalValido();
		profesional.setDni(27666543L);
		profesional.setNombre("Monica");
		profesional.setApellido("Diaz");
        profesional.setAcceso(UsuarioHelper.creatDatosAccesoValido());
        profesional.setTelefono(224566777);
        profesional.setIsAdmin("PROFESIONAL");
        
        return profesional;
	}

}