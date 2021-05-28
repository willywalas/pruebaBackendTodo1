package com.example.prueba.Williams.Samaniego.Ccanihua;

import com.example.prueba.Williams.Samaniego.Ccanihua.controller.PersonaController;
import com.example.prueba.Williams.Samaniego.Ccanihua.controller.ProductoController;
import com.example.prueba.Williams.Samaniego.Ccanihua.controller.TipoProductoController;
import com.example.prueba.Williams.Samaniego.Ccanihua.controller.VentaController;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.TipoProducto;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PruebaWilliamsSamaniegoCcanihuaApplicationTests {
	@Autowired
	private PersonaController personaController;
	@Autowired
	private ProductoController productoController;
	@Autowired
	private TipoProductoController tipoProductoController;
	@Autowired
	private VentaController ventaController;

	@Test
	void contextLoads() {
	}

	@Test
	void validatePersonaController(){
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(personaController).isNotNull();
	}
	@Test
	void validateProducteController(){
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(productoController).isNotNull();
	}
	@Test
	void validatetipoController(){
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(tipoProductoController).isNotNull();
	}
	@Test
	void validateVentaController(){
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(ventaController).isNotNull();
	}

}
