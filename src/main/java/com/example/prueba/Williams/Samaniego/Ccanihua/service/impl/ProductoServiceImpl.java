package com.example.prueba.Williams.Samaniego.Ccanihua.service.impl;

import com.example.prueba.Williams.Samaniego.Ccanihua.domain.venta.ProductoRequest;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.TipoProducto;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.PersonaRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.ProductoRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.BASE64DecodedMultipartFile;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.ProductoService;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private StorageService service;

    @Override
    public ResponseEntity<?> createProducto(ProductoRequest productorequest) {
        Producto objProducto = new Producto();
        TipoProducto objTipoProducto = new TipoProducto();
        //objProducto.setId(producto.getId());
        objProducto.setPrecio(productorequest.getPrecio());
        objProducto.setStock(productorequest.getStock());
        objProducto.setNombre(productorequest.getNombre());
        //objProducto.setImagen(producto.getImagen());

        service.uploadFile(productorequest.getImagen(),objProducto);
        objProducto.setDescripcion(productorequest.getDescripcion());
        objTipoProducto.setId((long) productorequest.getTipoProducto());
        objProducto.setTipoProducto(objTipoProducto);


        return ResponseEntity.status(HttpStatus.CREATED).body(productoRepository.save(objProducto));
    }

    @Override
    public ResponseEntity<?> getProductoById(Long productoId) {
        Optional<Producto> oProducto=productoRepository.findById(productoId);

        //service.getFile(oProducto.getClass().getName());
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
