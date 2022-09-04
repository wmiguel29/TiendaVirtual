package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {

    public List<Empleado> findAll();

    public Empleado findById(long id);

    public Empleado save(Empleado e);

    public void delete(long id);
}
