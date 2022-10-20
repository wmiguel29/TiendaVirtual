package com.implementacion.tienda_virtual.services;


import com.implementacion.tienda_virtual.dao.IProductoDAO;
import com.implementacion.tienda_virtual.entity.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductoServiceTest {
    
    @MockBean
    private IProductoDAO productoDAO;

    @Autowired
    private ProductoService productoService;

    private Producto producto;

    @BeforeEach
    public void setUp() {
        producto = new Producto();
        producto.setNombre("producto 1");
        producto.setDescripcion("Definitivamente es un producto");
        producto.setPrecio(120.0);

    }

    @Test
    void findAll() {
        when(productoDAO.findAll()).thenReturn(List.of(producto));
        assertThat(productoService.findAll()).isNotNull();
    }


    @Test
    void findById() {
        when(productoDAO.findById(1L)).thenReturn(java.util.Optional.of(producto));
        Producto producto = productoService.findById(1L);
        assertNotNull(producto);
    }

    @Test
    void save() {
        when(productoDAO.save(producto)).thenReturn(producto);
        assertNotNull(productoService.save(producto));
    }

    @Test
    void delete() {
        productoService.delete(producto.getId());
        verify(productoDAO).deleteById(producto.getId());
    }

    @Test
    void update() {
        producto = new Producto();
        producto.setNombre("producto 1");
        producto.setDescripcion("Definitivamente es un producto");
        producto.setPrecio(120.0);

        when(productoDAO.findById(1L)).thenReturn(java.util.Optional.of(producto));
        when(productoDAO.save(producto)).thenReturn(producto);

        Producto actual = productoService.update(1L, producto);
        assertEquals(producto.getNombre(), actual.getNombre());
    }
}
