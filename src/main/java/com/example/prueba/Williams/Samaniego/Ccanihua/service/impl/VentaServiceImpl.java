package com.example.prueba.Williams.Samaniego.Ccanihua.service.impl;

import com.example.prueba.Williams.Samaniego.Ccanihua.domain.venta.VentaRequest;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Venta;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.ProductoRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.VentaRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    VentaRepository ventaRepository;

    @Override
    public ResponseEntity<?> createVenta(VentaRequest venta) {
        Venta objVenta=new Venta();
        Optional<Producto>  producto=productoRepository.findById((long) venta.getIdProducto());
        if(producto.get().getStock()>=venta.getCantidadProducto()){
            int nuevoStock=producto.get().getStock()-venta.getCantidadProducto();

            producto.get().setStock(nuevoStock);
            productoRepository.save(producto.get());

            objVenta.setNombreProducto(venta.getNombreProducto());
            objVenta.setCantidad(venta.getCantidadProducto());
            objVenta.setMontoTotal(venta.getMontoTotal());
            return ResponseEntity.status(HttpStatus.CREATED).body(ventaRepository.save(objVenta));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay stock suficiente");
        }

    }
}
