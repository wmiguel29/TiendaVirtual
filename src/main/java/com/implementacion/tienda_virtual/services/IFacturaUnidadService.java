package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.entity.FacturaUnidad;

import java.util.List;

public interface IFacturaUnidadService {

    public List<FacturaUnidad> findAll();

    public FacturaUnidad findByIds(Long id, Long id2);

    public FacturaUnidad save(FacturaUnidad facturaUnidad);

    public void delete(Long id, Long id2);

    //public FacturaUnidad update(Long id, Long id2, FacturaUnidad facturaUnidad);
}
