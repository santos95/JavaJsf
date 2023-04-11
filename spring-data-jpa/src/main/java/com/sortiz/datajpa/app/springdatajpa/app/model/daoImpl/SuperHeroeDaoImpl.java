package com.sortiz.datajpa.app.springdatajpa.app.model.daoImpl;

import com.sortiz.datajpa.app.springdatajpa.app.model.dao.SuperHeoreDao;
import com.sortiz.datajpa.app.springdatajpa.app.model.entity.SuperHeroe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SuperHeroeDaoImpl implements SuperHeoreDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<SuperHeroe> findAll() {
        return em.createQuery("from SuperHeroe").getResultList();
    }
}
