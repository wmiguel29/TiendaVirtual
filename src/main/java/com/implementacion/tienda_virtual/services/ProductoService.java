package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IProductoDAO;
import com.implementacion.tienda_virtual.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public void delete(Long id) {
        productoDAO.deleteById(id);
    }

    public Producto update(Long productoId, Producto producto) {
        Producto p = findById(productoId);

        if (p != null){
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());
            p.setDescripcion(producto.getDescripcion());
        }
        else {
            return null;
        }
        return productoDAO.save(p);
    }
}
