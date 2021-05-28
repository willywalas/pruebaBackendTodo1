package com.example.prueba.Williams.Samaniego.Ccanihua.repository;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

    @Transactional
    Producto save(Producto producto);

    @Transactional(readOnly = true)
    Optional<Producto> findById(Long id);

    @Transactional(readOnly = true)
    List<Producto> findByTipoProductoId(Long id);

    @Override
    @Transactional
    void deleteById(Long id);

    @Override
    @Transactional(readOnly = true)
    List<Producto> findAll();

}
