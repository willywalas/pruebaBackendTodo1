package com.example.prueba.Williams.Samaniego.Ccanihua.repository;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import com.example.prueba.Williams.Samaniego.Ccanihua.entity.TipoProducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    @Override
    @Transactional
    Persona save(Persona persona);

    @Override
    @Transactional(readOnly = true)
    Optional<Persona> findById(Long id);

    @Transactional(readOnly = true)
    Optional<Persona> findByUsuarioAndContrasenia(String usuario,String contrasenia);

    @Override
    @Transactional
    void deleteById(Long id);

    @Override
    @Transactional(readOnly = true)
    List<Persona> findAll();
}
