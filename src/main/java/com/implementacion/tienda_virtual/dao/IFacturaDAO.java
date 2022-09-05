package com.implementacion.tienda_virtual.dao;

import com.implementacion.tienda_virtual.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaDAO extends JpaRepository<Factura, Long> {


}
