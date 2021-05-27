package com.example.prueba.Williams.Samaniego.Ccanihua.service;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface PersonaService {
        ResponseEntity<?> createPersona(Persona persona);
        ResponseEntity<?> loginPersona(Persona persona);
        ResponseEntity<?> getPersonaById(Long personaId);
        ResponseEntity<?> updatePersonaById(Long personaId,Persona personaDetails);
        ResponseEntity<?> deletePersonaById(Long personaId);
        ResponseEntity<?> getAllPersona();

}
