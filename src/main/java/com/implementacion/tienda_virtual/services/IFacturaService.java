package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.entity.Factura;

import java.util.List;

public interface IFacturaService {

    public List<Factura> findAll();

    public Factura findById(Long id);

    public Factura save(Factura f);

    public void delete(Long id);

}
