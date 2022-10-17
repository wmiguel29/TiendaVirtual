package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.entity.Sucursal;

import java.util.List;

public interface ISucursalService {

    public List<Sucursal> findAll();

    public Sucursal findById(Long id);

    public Sucursal save(Sucursal sucursal);

    public void delete(Long id);


}
