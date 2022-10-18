package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IFacturaUnidadDAO;
import com.implementacion.tienda_virtual.entity.FacturaUnidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaUnidadService implements IFacturaUnidadService {

    @Autowired
    private IFacturaUnidadDAO facturaUnidadDAO;

    @Override
    public FacturaUnidad save(FacturaUnidad facturaUnidad) {
        return facturaUnidadDAO.save(facturaUnidad);
    }

    @Override
    public void delete(Long id, Long id2) {
        facturaUnidadDAO.deleteById(id);
    }

    @Override
    public FacturaUnidad findByIds(Long id, Long id2) {
        return facturaUnidadDAO.findById(id).orElse(null);
    }

    @Override
    public List<FacturaUnidad> findAll() {
        return facturaUnidadDAO.findAll();
    }




}
