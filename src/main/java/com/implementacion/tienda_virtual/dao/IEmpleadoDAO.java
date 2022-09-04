package com.implementacion.tienda_virtual.dao;

import com.implementacion.tienda_virtual.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long> {

}
