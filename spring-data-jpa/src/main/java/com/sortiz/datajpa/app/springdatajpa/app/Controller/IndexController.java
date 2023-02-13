package com.sortiz.datajpa.app.springdatajpa.app.Controller;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope(value = "session")
public class IndexController {
    @GetMapping("")
    public String index(){
        return "index";
    }
}
