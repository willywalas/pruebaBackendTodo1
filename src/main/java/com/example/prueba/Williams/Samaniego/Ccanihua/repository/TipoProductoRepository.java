package com.example.prueba.Williams.Samaniego.Ccanihua.repository;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TipoProductoRepository extends JpaRepository<TipoProducto,Long> {

    @Override
    @Transactional(readOnly = true)
    List<TipoProducto> findAll();
}
