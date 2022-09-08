package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IProveedorDAO;
import com.implementacion.tienda_virtual.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorDAO proveedorDAO;

    @Override
    public List<Proveedor> findAll() {
        return proveedorDAO.findAll();
    }

    @Override
    public Proveedor findById(Long id) {
        return proveedorDAO.findById(id).orElse(null);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorDAO.save(proveedor);
    }

    @Override
    public void delete(Long id) {
        proveedorDAO.deleteById(id);
    }

    public Proveedor update(Long proveedorId, Proveedor proveedor) {
        Proveedor p = findById(proveedorId);

        if (p != null){
            p.setNombre(proveedor.getNombre());
            p.setEmail(proveedor.getEmail());
            p.setTelefono(proveedor.getTelefono());
        }
        else {
            return null;
        }
        return proveedorDAO.save(p);

    }
}
