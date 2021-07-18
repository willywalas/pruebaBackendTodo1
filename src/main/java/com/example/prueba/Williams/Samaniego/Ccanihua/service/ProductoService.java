package com.example.prueba.Williams.Samaniego.Ccanihua.service;

import com.example.prueba.Williams.Samaniego.Ccanihua.domain.venta.ProductoRequest;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import org.springframework.http.ResponseEntity;

public interface ProductoService {
    ResponseEntity<?> createProducto(ProductoRequest producto);
    ResponseEntity<?> getProductoById(Long productoId);
    ResponseEntity<?> getProductoByTipoProducto(Long productoId);
    ResponseEntity<?> updateProductoById(Long productoId,Producto productoDetails);
    ResponseEntity<?> deleteProductoById(Long productoId);
    ResponseEntity<?> getAllProducto();
}
