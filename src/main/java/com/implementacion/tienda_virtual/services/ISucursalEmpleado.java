package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.entity.Empleado;
import com.implementacion.tienda_virtual.entity.Sucursal;
import com.implementacion.tienda_virtual.entity.SucursalEmpleado;

import java.util.List;

public interface ISucursalEmpleado {

    public List<SucursalEmpleado> findAll();

    public SucursalEmpleado findByIds(Long id, Long id2);

    public SucursalEmpleado save(SucursalEmpleado sucursalEmpleado);

    public void delete(Long id, Long id2);

    //public SucursalEmpleado update(Long id, Long id2, SucursalEmpleado sucursalEmpleado);

//    public List<SucursalEmpleado> findBySucursal(Long id);
//
//    public List<SucursalEmpleado> findByEmpleado(Long id);


}
