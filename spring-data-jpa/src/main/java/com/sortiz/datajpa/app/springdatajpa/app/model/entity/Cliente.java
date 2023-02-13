package com.sortiz.datajpa.app.springdatajpa.app.model.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

    private String email;
    @Column(name="created_at")
    @Temporal(TemporalType.DATE) //indica el formato
    private Date createdAt;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @PrePersist
    public void prePersist(){
        this.createdAt = new Date();
    }
}
