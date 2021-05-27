package com.example.prueba.Williams.Samaniego.Ccanihua.controller;

import com.example.prueba.Williams.Samaniego.Ccanihua.entity.Persona;
import com.example.prueba.Williams.Samaniego.Ccanihua.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Persona persona){
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>read(@PathVariable(value="id")Long userId){
        Optional<Persona> oPersona=personaService.findById(userId);

        if(!oPersona.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPersona);
    }

    @PutMapping("/id")
    public ResponseEntity<?> update(@RequestBody Persona personaDetails, @PathVariable(value="id") Long personaId){
        Optional<Persona> persona=personaService.findById(personaId);

        if(!persona.isPresent()){
            return ResponseEntity.notFound().build();
        }

        persona.get().setContrasenia(personaDetails.getContrasenia());
        persona.get().setContrasenia(personaDetails.getNombre());
        persona.get().setContrasenia(personaDetails.getContrasenia());
        persona.get().setContrasenia(personaDetails.getUsuario());

        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id")Long personaId){
        if(!personaService.findById(personaId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        personaService.deleteById(personaId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Persona> readAll(){
        List<Persona> personas= StreamSupport.stream(personaService.findAll().spliterator(),false).collect(Collectors.toList());

        return personas;
    }
}
