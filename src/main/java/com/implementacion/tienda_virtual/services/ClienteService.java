package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IClienteDAO;
import com.implementacion.tienda_virtual.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteDAO clienteDAO;
    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDAO.deleteById(id);
    }

    public Cliente update(Long clienteId, Cliente cliente) {
        Cliente c = findById(clienteId);

        if (c != null){
            c.setNombre(cliente.getNombre());
            c.setApellido(cliente.getApellido());
            c.setEmail(cliente.getEmail());
            c.setTelefono(cliente.getTelefono());
        }
        else {
            return null;
        }
        return clienteDAO.save(c);

    }

}
