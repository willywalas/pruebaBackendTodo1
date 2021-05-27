package com.example.prueba.Williams.Samaniego.Ccanihua.service;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface PersonaService {
    public Iterable<Persona> findAll();
    public Page<Persona> findAll(Pageable pageable);
    public Optional<Persona> findById(Long id);
    public Persona save(Persona persona);
    public void deleteById(Long id);
}
