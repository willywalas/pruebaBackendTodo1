package com.example.prueba.Williams.Samaniego.Ccanihua.service;

import com.example.prueba.Williams.Samaniego.Ccanihua.domain.venta.VentaRequest;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Venta;
import org.springframework.http.ResponseEntity;

public interface VentaService {
    ResponseEntity<?> createVenta(VentaRequest ventaRequest);
}
