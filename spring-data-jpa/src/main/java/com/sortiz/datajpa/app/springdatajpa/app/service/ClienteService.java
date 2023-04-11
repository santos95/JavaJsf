package com.sortiz.datajpa.app.springdatajpa.app.service;

import com.sortiz.datajpa.app.springdatajpa.app.model.dao.ClienteDao;
import com.sortiz.datajpa.app.springdatajpa.app.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteDao clienteDao;

    @Autowired
    public ClienteService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public List<Cliente> findAll(){
        return clienteDao.findAll();
    }

    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }
    public Cliente findOne(Long id) {
        return clienteDao.findOne(id);
    }

    public void eliminar(Long id) {

        if (0 < id) {

            clienteDao.remove(id);

        }

    }

}
