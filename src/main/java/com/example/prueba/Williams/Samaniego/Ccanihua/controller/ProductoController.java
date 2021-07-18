package com.example.prueba.Williams.Samaniego.Ccanihua.controller;

import com.example.prueba.Williams.Samaniego.Ccanihua.domain.venta.ProductoRequest;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute ProductoRequest productorequest){
        ResponseEntity<?>responseEntity=null;

        try {
            responseEntity=productoService.createProducto(productorequest);
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);;
        }
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?>read(@PathVariable(value="id")Long productoId){
        ResponseEntity<?>responseEntity=null;
        try {
            responseEntity=productoService.getProductoById(productoId);
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/tipoProducto/{id}")
    public ResponseEntity<?>getProductobyTipoProducto(@PathVariable(value="id")Long productoId){
        ResponseEntity<?>responseEntity=null;
        try {
            responseEntity=productoService.getProductoByTipoProducto(productoId);
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Producto productoDetails, @PathVariable(value="id") Long productoId){
        ResponseEntity<?>responseEntity=null;
        try {
            responseEntity=productoService.updateProductoById(productoId,productoDetails);
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id")Long productoId){
        ResponseEntity<?>responseEntity=null;
        try {
            responseEntity=productoService.deleteProductoById(productoId);
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> readAll(){
        ResponseEntity<?>responseEntity=null;
        try {
            responseEntity=productoService.getAllProducto();
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
