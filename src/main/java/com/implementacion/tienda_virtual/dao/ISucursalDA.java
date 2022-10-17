package com.implementacion.tienda_virtual.dao;

import com.implementacion.tienda_virtual.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISucursalDA extends JpaRepository<Sucursal, Long> {

}

