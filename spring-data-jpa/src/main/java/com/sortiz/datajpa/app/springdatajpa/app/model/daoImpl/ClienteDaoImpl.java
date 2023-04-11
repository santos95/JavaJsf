package com.sortiz.datajpa.app.springdatajpa.app.model.daoImpl;

import com.sortiz.datajpa.app.springdatajpa.app.model.dao.ClienteDao;
import com.sortiz.datajpa.app.springdatajpa.app.model.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClienteDaoImpl implements ClienteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {

        if (cliente.getId() != null && cliente.getId() > 0) {
            entityManager.merge(cliente);
        } else {
            entityManager.persist(cliente);
        }

    }

    @Override
    @Transactional
    public void remove(Long id) {

        // get the client by id and then remove it
        entityManager.remove(findOne(id));

    }
}
