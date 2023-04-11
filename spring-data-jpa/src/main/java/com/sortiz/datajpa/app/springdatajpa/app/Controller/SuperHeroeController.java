package com.sortiz.datajpa.app.springdatajpa.app.Controller;

import com.sortiz.datajpa.app.springdatajpa.app.model.dao.SuperHeoreDao;
import com.sortiz.datajpa.app.springdatajpa.app.model.entity.Group;
import com.sortiz.datajpa.app.springdatajpa.app.model.entity.SuperHeroe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/superheroe")
public class SuperHeroeController {

    private final SuperHeoreDao superHeoreDao;

    @Autowired
    public SuperHeroeController(SuperHeoreDao superHeoreDao) {
        this.superHeoreDao = superHeoreDao;
    }

    @GetMapping("/all")
    public String listAll(Model model) {

        Group group = null;
        List<SuperHeroe> heroes = superHeoreDao.findAll();

        model.addAttribute("title", "List of Super Heroes");
        model.addAttribute("superheroes", heroes);
        model.addAttribute("group", group);
        return "superHeroesList";

    }

}
