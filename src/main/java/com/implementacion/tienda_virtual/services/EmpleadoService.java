package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IEmpleadoDAO;
import com.implementacion.tienda_virtual.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService{

    @Autowired
    public IEmpleadoDAO empleadoDAO;

    @Override
    public List<Empleado> findAll() {
       return empleadoDAO.findAll();
    }

    @Override
    public Empleado findById(long id) {
        return empleadoDAO.findById(id).orElse(null);
    }

    @Override
    public Empleado save(Empleado e) {
        return empleadoDAO.save(e);
    }

    @Override
    public void delete(long id) {
        empleadoDAO.deleteById(id);
    }


}
