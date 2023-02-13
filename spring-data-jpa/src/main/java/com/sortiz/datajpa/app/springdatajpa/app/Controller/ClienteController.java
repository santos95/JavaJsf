package com.sortiz.datajpa.app.springdatajpa.app.Controller;

import com.sortiz.datajpa.app.springdatajpa.app.model.entity.Cliente;
import com.sortiz.datajpa.app.springdatajpa.app.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/cliente")
public class ClienteController {


    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @GetMapping("/all")
    public String listAll(Model model){
        model.addAttribute("title", "Listado Clientes");
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }

    @GetMapping
    public String hello(){
        return "listarClientes";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model){
        Cliente cliente = new Cliente();
        model.put("title", "Customer Form");
        model.put("cliente", cliente);
        return "/clienteForm";
    }

    @PostMapping("/form")
    public String guardar(Cliente cliente){
        clienteService.save(cliente);
        return "/all";
    }
}
