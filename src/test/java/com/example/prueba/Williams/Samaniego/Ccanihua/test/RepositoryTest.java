package com.example.prueba.Williams.Samaniego.Ccanihua.test;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.TipoProducto;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Venta;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.PersonaRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.ProductoRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.TipoProductoRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.VentaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    TipoProductoRepository tipoProductoRepository;
    @Autowired
    VentaRepository ventaRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Test
    @Order(1)
    public void ventaCreate () {
        Venta objVenta = new Venta();
        objVenta.setId(1L);
        objVenta.setNombreProducto("camiseta XXL");
        objVenta.setCantidad(2);
        objVenta.setMontoTotal(2.3);
        ventaRepository.save(objVenta);
        assertNotNull(ventaRepository.findById(1L));
    }

    @Test
    @Order(2)
    public void getTipoProductoAll () {
        List list = tipoProductoRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void productoCreate () {
        Producto objProducto = new Producto();
        TipoProducto objTipoProducto = new TipoProducto();
        objTipoProducto.setId(1L);

        objProducto.setId(1L);
        objProducto.setImagen("imagen");
        objProducto.setTipoProducto(objTipoProducto);
        objProducto.setStock(3);
        objProducto.setNombre("nombre");
        objProducto.setDescripcion("descripcion");
        objProducto.setPrecio(2.4);
        productoRepository.save(objProducto);
        assertNotNull(productoRepository.findById(1L).get());
    }

    @Test
    @Order(4)
    public void getProductoById () {
        Producto product = productoRepository.findById(1L).get();
        assertEquals("Bativaso", product.getNombre());
    }
    @Test
    @Order(4)
    public void getProductoByTipoProducto () {
        List<Producto> product = productoRepository.findByTipoProductoId(1L);
        assertThat(product).size().isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void testDeleteProducto () {
        /*productoRepository.deleteById(1L);
        assertThat(productoRepository.existsById(1L)).isFalse();*/
    }

    @Test
    @Order(6)
    public void testGetProductoAll () {
        List list = productoRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(7)
    public void testCreatePersona () {
        Persona objPersona = new Persona();
        objPersona.setId(1L);
        objPersona.setUsuario("prueba");
        objPersona.setContrasenia("1234");
        objPersona.setNombre("Williams");
        objPersona.setTipoUsuario("admin");
        personaRepository.save(objPersona);
        assertNotNull(personaRepository.findById(1L).get());
    }

    @Test
    @Order(8)
    public void testGetPersonaById () {
        Persona objPersona = personaRepository.findById(1L).get();
        assertEquals("Williams", objPersona.getNombre());
    }

    @Test
    @Order(9)
    public void testGetPersonaByUsuarioAndPassword () {
        Persona objPersona = personaRepository.findByUsuarioAndContrasenia("wsamaniego","1234").get();
        assertEquals("Williams", objPersona.getNombre());
    }

    @Test
    @Order(10)
    public void testDeletePersona () {
        /*personaRepository.deleteById(1L);
        assertThat(personaRepository.existsById(1L)).isFalse();*/
    }

    @Test
    @Order(11)
    public void testAllPersona () {
        List list = personaRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
}
