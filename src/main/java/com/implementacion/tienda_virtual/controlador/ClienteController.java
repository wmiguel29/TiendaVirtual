package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.entity.Cliente;
import com.implementacion.tienda_virtual.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{idClientes}")
    public Cliente findByID(@PathVariable Long idClientes){
        return clienteService.findById(idClientes);
    }

    @DeleteMapping("/clientes/{idClientes}")
    public void delete(@PathVariable Long idClientes){
        clienteService.delete(idClientes);
    }

    @PostMapping("/clientes")
    public Cliente save(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{idClientes}")
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long idClientes){
        Cliente actual = clienteService.findById(idClientes);
        actual.setNombre(cliente.getNombre());
        actual.setApellido(cliente.getApellido());
        actual.setTelefono(cliente.getTelefono());
        actual.setEmail(cliente.getEmail());

        return clienteService.save(actual);
    }




}
