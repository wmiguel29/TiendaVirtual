package com.implementacion.tienda_virtual.dao;

import com.implementacion.tienda_virtual.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDAO extends JpaRepository<Producto, Long> {

}


