package com.example.prueba.Williams.Samaniego.Ccanihua.controller;

import com.example.prueba.Williams.Samaniego.Ccanihua.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoProducto")
public class TipoProductoController {
    @Autowired
    TipoProductoService tipoProductoService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> readAll(){
        ResponseEntity<?>responseEntity=null;
        try {
            responseEntity=tipoProductoService.getAllTipoProducto();
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
