package com.sortiz.datajpa.app.springdatajpa.app.model.dao;

import com.sortiz.datajpa.app.springdatajpa.app.model.entity.Cliente;

import java.util.List;

public interface ClienteDao {
    List<Cliente> findAll();

    void save(Cliente cliente);
}
