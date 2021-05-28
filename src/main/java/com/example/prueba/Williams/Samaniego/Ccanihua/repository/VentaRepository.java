package com.example.prueba.Williams.Samaniego.Ccanihua.repository;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface VentaRepository extends JpaRepository<Producto,Long> {

    @Transactional
    Venta save(Venta venta);
}
