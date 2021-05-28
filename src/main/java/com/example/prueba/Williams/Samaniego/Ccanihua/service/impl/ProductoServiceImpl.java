package com.example.prueba.Williams.Samaniego.Ccanihua.service.impl;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.TipoProducto;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.PersonaRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.ProductoRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ResponseEntity<?> createProducto(Producto producto) {
        Producto objProducto = new Producto();
        TipoProducto objTipoProducto = new TipoProducto();
        objProducto.setId(producto.getId());

        objProducto.setPrecio(producto.getPrecio());
        objProducto.setStock(producto.getStock());
        objProducto.setNombre(producto.getNombre());
        objProducto.setImagen(producto.getImagen());
        objProducto.setDescripcion(producto.getDescripcion());
        objProducto.setTipoProducto(objTipoProducto);


        return ResponseEntity.status(HttpStatus.CREATED).body(productoRepository.save(producto));
    }

    @Override
    public ResponseEntity<?> getProductoById(Long productoId) {
        Optional<Producto> oProducto=productoRepository.findById(productoId);

        if(!oProducto.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oProducto);
    }

    @Override
    public ResponseEntity<?> getProductoByTipoProducto(Long personaId) {
        List<Producto> oProducto=productoRepository.findByTipoProductoId(personaId);

        if(oProducto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oProducto);
    }

    @Override
    public ResponseEntity<?> updateProductoById(Long personaId, Producto productoDetails) {
        Optional<Producto> producto=productoRepository.findById(personaId);

        if(!producto.isPresent()){
            return ResponseEntity.notFound().build();
        }

        producto.get().setDescripcion(productoDetails.getDescripcion());
        producto.get().setPrecio(productoDetails.getPrecio());
        producto.get().setStock(productoDetails.getStock());
        producto.get().setPrecio(productoDetails.getPrecio());
        producto.get().setTipoProducto(productoDetails.getTipoProducto());

        return ResponseEntity.status(HttpStatus.CREATED).body(productoRepository.save(producto.get()));
    }

    @Override
    public ResponseEntity<?> deleteProductoById(Long productoId) {
        if(!productoRepository.findById(productoId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        productoRepository.deleteById(productoId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getAllProducto() {
        List<Producto> productos= StreamSupport.stream(productoRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return new ResponseEntity<>(productos,HttpStatus.OK);
    }
}
