package com.example.prueba.Williams.Samaniego.Ccanihua.controller;

import com.example.prueba.Williams.Samaniego.Ccanihua.domain.venta.VentaRequest;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Venta;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody VentaRequest ventaRequest){
        ResponseEntity<?>responseEntity=null;

        try {
            responseEntity=ventaService.createVenta(ventaRequest);
        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);;
        }
        return responseEntity;
    }
}
