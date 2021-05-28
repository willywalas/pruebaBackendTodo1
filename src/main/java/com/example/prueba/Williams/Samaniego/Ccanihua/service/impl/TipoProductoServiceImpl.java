package com.example.prueba.Williams.Samaniego.Ccanihua.service.impl;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.TipoProducto;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.TipoProductoRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.ProductoService;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {
    @Autowired
    TipoProductoRepository tipoProductoRepository;
    @Override
    public ResponseEntity<?> getAllTipoProducto() {
        List<TipoProducto> tipoProductos= StreamSupport.stream(tipoProductoRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return new ResponseEntity<>(tipoProductos, HttpStatus.OK);
    }
}
