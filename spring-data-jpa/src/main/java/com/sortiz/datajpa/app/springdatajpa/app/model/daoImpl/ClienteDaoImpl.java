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
    @Transactional
    public void save(Cliente cliente) {
        entityManager.persist(cliente);
    }
}
