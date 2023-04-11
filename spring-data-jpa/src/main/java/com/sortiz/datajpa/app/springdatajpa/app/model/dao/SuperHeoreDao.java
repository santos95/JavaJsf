package com.sortiz.datajpa.app.springdatajpa.app.model.dao;

import com.sortiz.datajpa.app.springdatajpa.app.model.entity.SuperHeroe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperHeoreDao {

    List<SuperHeroe> findAll();

}
