package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IFacturaDAO;
import com.implementacion.tienda_virtual.entity.Empleado;
import com.implementacion.tienda_virtual.entity.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService implements IFacturaService{

    @Autowired
    private IFacturaDAO facturaDAO;

    @Override
    public List<Factura> findAll() {return facturaDAO.findAll();}

    @Override
    public Factura findById(Long id) {return facturaDAO.findById(id).orElse(null);}

    @Override
    public Factura save(Factura f) {return facturaDAO.save(f);}

    @Override
    public void delete(Long id) {facturaDAO.deleteById(id);}

}
