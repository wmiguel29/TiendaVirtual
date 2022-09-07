package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(Long id);

    public Producto save(Producto producto);

    public void delete(Long id);

}
