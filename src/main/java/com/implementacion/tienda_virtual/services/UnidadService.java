package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IUnidadDAO;
import com.implementacion.tienda_virtual.entity.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadService implements  IUnidadService {

    @Autowired
    private IUnidadDAO unidadDAO;

    @Override
    public List<Unidad> findAll() {
        return unidadDAO.findAll();
    }

    @Override
    public Unidad findById(Long id) {
        return unidadDAO.findById(id).orElse(null);
    }

    @Override
    public Unidad save(Unidad unidad) {
        return unidadDAO.save(unidad);
    }

    @Override
    public void delete(Long id) {
        unidadDAO.deleteById(id);
    }

    public Unidad update(Long unidadId, Unidad unidad) {
        Unidad u = findById(unidadId);

        if (u != null){
            u.setIdproducto(unidad.getIdproducto());
            u.setIdproveedor(unidad.getIdproveedor());
            u.setIdsucursal(unidad.getIdsucursal());
        }
        else {
            return null;
        }
        return unidadDAO.save(u);

    }
}
