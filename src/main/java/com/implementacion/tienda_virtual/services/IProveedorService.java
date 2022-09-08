package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.entity.Proveedor;

import java.util.List;

public interface IProveedorService {

    public List<Proveedor> findAll();

    public Proveedor findById(Long id);

    public Proveedor save(Proveedor proveedor);

    public void delete(Long id);

}
