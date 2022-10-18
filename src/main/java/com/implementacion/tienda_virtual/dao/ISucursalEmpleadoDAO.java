package com.implementacion.tienda_virtual.dao;

import com.implementacion.tienda_virtual.entity.SucursalEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISucursalEmpleadoDAO extends JpaRepository<SucursalEmpleado, Long> {

}
