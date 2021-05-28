package com.example.prueba.Williams.Samaniego.Ccanihua.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TipoProducto")
public class TipoProducto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    /*@OneToMany(targetEntity=Producto.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy="tipoProducto")
    Set<Producto> producto = new HashSet<Producto>();*/

    @OneToMany(mappedBy = "tipoProducto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> producto;

    public TipoProducto(Long id) {
        super();
        this.id = id;
    }

    public TipoProducto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
