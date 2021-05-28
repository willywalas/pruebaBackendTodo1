package com.example.prueba.Williams.Samaniego.Ccanihua.service.impl;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import com.example.prueba.Williams.Samaniego.Ccanihua.repository.PersonaRepository;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public ResponseEntity<?> createPersona(Persona persona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaRepository.save(persona));
    }

    @Override
    public ResponseEntity<?> loginPersona(Persona persona) {
        Optional<Persona> oPersona=personaRepository.findByUsuarioAndContrasenia(persona.getUsuario(),persona.getContrasenia());
        if(!oPersona.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPersona);
    }

    @Override
    public ResponseEntity<?> getPersonaById(Long personaId) {
        Optional<Persona> oPersona=personaRepository.findById(personaId);

        if(!oPersona.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPersona);
    }

    @Override
    public ResponseEntity<?> updatePersonaById(Long personaId,Persona personaDetails) {
        Optional<Persona> persona=personaRepository.findById(personaId);

        if(!persona.isPresent()){
            return ResponseEntity.notFound().build();
        }

        persona.get().setContrasenia(personaDetails.getContrasenia());
        persona.get().setNombre(personaDetails.getNombre());
        persona.get().setTipoUsuario(personaDetails.getTipoUsuario());
        persona.get().setUsuario(personaDetails.getUsuario());

        return ResponseEntity.status(HttpStatus.CREATED).body(personaRepository.save(persona.get()));
    }

    @Override
    public ResponseEntity<?> deletePersonaById(Long personaId) {
        if(!personaRepository.findById(personaId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        personaRepository.deleteById(personaId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getAllPersona() {
        List<Persona> personas= StreamSupport.stream(personaRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return new ResponseEntity<>(personas,HttpStatus.OK);
    }


}
