package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.entity.Unidad;

import java.util.List;

public interface IUnidadService {

    public List<Unidad> findAll();

    public Unidad findById(Long id);

    public Unidad save(Unidad unidad);

    public void delete(Long id);

}
