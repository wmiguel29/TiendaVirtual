package com.implementacion.tienda_virtual.dao;


import com.implementacion.tienda_virtual.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


//Preguntar si es necesario el @Repository

public interface IClienteDAO extends JpaRepository<Cliente, Long> {



}
