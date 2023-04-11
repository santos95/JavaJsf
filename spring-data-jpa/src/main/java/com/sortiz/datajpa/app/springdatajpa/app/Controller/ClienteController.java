package com.sortiz.datajpa.app.springdatajpa.app.Controller;

import com.sortiz.datajpa.app.springdatajpa.app.model.entity.Cliente;
import com.sortiz.datajpa.app.springdatajpa.app.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {


    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public String format(Date date) {
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        return fm.format(date);
    }

    @GetMapping("/all")
    public String listAll(Model model){
        List<Cliente> cliente = new ArrayList<>();
        cliente.addAll(clienteService.findAll());

        List<Cliente> list = cliente
                .stream()
                .map(c -> {
                    String name = c.getNombre();
                    String last = c.getApellido();
                    c.setNombre(name.toUpperCase());
                    c.setApellido(last.toUpperCase());
                    c.setCreatedAt(c.getCreatedAt());
                    return c;
                })
                .collect(Collectors.toList());


        model.addAttribute("title", "Listado Clientes");
        model.addAttribute("clientes", list);

        return "listar";
    }

    @GetMapping
    public String hello(){
        return "listarClientes";
    }

    @RequestMapping("/form/{id}")
    public String editar(@PathVariable Long id, Map<String, Object> model) {

        Cliente cliente = null;

        if (id > 0){
            cliente = clienteService.findOne(id);
            model.put("title", "Edit Custumer");
            model.put("cliente", cliente);

            return "/clienteForm";

        } else {
            return "redirect:/all";
        }

    }
    @GetMapping("/form")
    public String crear(Map<String, Object> model){
        Cliente cliente = new Cliente();
        model.put("title", "Customer Form");
        model.put("cliente", cliente);
        return "/clienteForm";
    }

//    el objeto mapeado Cliente cliente entre crear y guardar
//    el cliente no se pasa en el guardar explicitamente en este codigo por debajo lo hace
//    debido a que aca tienen el mismo nombre lo pasa por debajo  si se llamase distinto
//    @Valid @ModelAttribute("cliente") Cliente cliente - especifica que el objeto cliente en crear se pasa en guardar
    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model){

        if (result.hasErrors()){
            model.addAttribute("title", "Custumer Form");
            return "/clienteForm";
        }

        clienteService.save(cliente);
        return "redirect:all";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {

        clienteService.eliminar(id);

        return "redirect:/cliente/all";

    }
}
