package com.implementacion.tienda_virtual.dao;


import com.implementacion.tienda_virtual.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedorDAO extends JpaRepository<Proveedor, Long> {

}

