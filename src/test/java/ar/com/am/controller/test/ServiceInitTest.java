package ar.com.am.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import ar.com.am.controllers.admin.ServiceAdminController;
import ar.com.am.dtos.ServicioDTO;


@SpringBootTest
@ActiveProfiles("test")
public class ServiceInitTest {

    @Autowired
    private ServiceAdminController controller;

    @Test
    public void testInit() {
        Model model = new ConcurrentModel();

        // Llamamos al método del controlador
        String viewName = controller.init(model);

        // Verificamos la vista
        assertEquals("/admin/servicios/list", viewName);

        // Verificamos que el modelo tenga el listado
        assertTrue(model.containsAttribute("listado"));

        @SuppressWarnings("unchecked")
        List<ServicioDTO> listado = (List<ServicioDTO>) model.getAttribute("listado");
        
        // Validamos que haya datos (cargados previamente en tu BD de test)
        assertNotNull(listado);
        assertFalse(listado.isEmpty());

        // Como cargamos datos en data.sql, deberían estar presentes
        assertEquals(58, listado.size());
        assertEquals("Capping", listado.get(0).getNombre());
    }
}


