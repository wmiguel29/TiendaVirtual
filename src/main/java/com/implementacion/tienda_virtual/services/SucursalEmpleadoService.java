package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.ISucursalEmpleadoDAO;
import com.implementacion.tienda_virtual.entity.SucursalEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalEmpleadoService implements ISucursalEmpleado {

    @Autowired
    private ISucursalEmpleadoDAO sucursalEmpleadoDAO;

    @Override
    public SucursalEmpleado save(SucursalEmpleado sucursalEmpleado) {
        return sucursalEmpleadoDAO.save(sucursalEmpleado);
    }

    @Override
    public void delete(Long id, Long id2) {
        sucursalEmpleadoDAO.deleteById(id);
    }

    @Override
    public SucursalEmpleado findByIds(Long id, Long id2) {
        return sucursalEmpleadoDAO.findById(id).orElse(null);
    }

    @Override
    public List<SucursalEmpleado> findAll() {
        return sucursalEmpleadoDAO.findAll();
    }


    //Para Preguntar

//    @Override
//    public List<SucursalEmpleado> findBySucursal(Long id) {
//        return sucursalEmpleadoDAO.findBySucursal(id);
//    }
//
//    @Override
//    public List<SucursalEmpleado> findByEmpleado(Long id) {
//        return sucursalEmpleadoDAO.findByEmpleado(id);
//    }
}
