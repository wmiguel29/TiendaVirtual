package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.ISucursalDA;
import com.implementacion.tienda_virtual.entity.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    private ISucursalDA sucursalDAO;

    @Override
    public List<Sucursal> findAll() {
        return sucursalDAO.findAll();
    }

    @Override
    public Sucursal findById(Long id) {
        return sucursalDAO.findById(id).orElse(null);
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return sucursalDAO.save(sucursal);
    }

    @Override
    public void delete(Long id) {
        sucursalDAO.deleteById(id);
    }

public Sucursal update(Long sucursalId, Sucursal sucursal) {
        Sucursal s = findById(sucursalId);

        if (s != null){
            s.setNombre(sucursal.getNombre());
            s.setDireccion(sucursal.getDireccion());
        }
        else {
            return null;
        }
        return sucursalDAO.save(s);

    }

}
