package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IProveedorDAO;
import com.implementacion.tienda_virtual.entity.Proveedor;
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
public class ProveedorServiceTest {

    @MockBean
    private IProveedorDAO proveedorDAO;

    @Autowired
    private ProveedorService proveedorService;

    private Proveedor proveedor;

    @BeforeEach
    public void setUp() {
        proveedor = new Proveedor();
        proveedor.setNombre("Proveedor 1");
        proveedor.setTelefono("123456789");
        proveedor.setEmail("@gmail.com");

    }

    @Test
    void findAll() {
        when(proveedorDAO.findAll()).thenReturn(List.of(proveedor));
        assertThat(proveedorService.findAll()).isNotNull();
    }


    @Test
    void findById() {
        when(proveedorDAO.findById(1L)).thenReturn(java.util.Optional.of(proveedor));
        Proveedor proveedor = proveedorService.findById(1L);
        assertNotNull(proveedor);
    }

    @Test
    void save() {
        when(proveedorDAO.save(proveedor)).thenReturn(proveedor);
        assertNotNull(proveedorService.save(proveedor));
    }

    @Test
    void delete() {
        proveedorService.delete(proveedor.getId());
        verify(proveedorDAO).deleteById(proveedor.getId());
    }

    @Test
    void update() {
        proveedor = new Proveedor();
        proveedor.setNombre("Proveedor 1");
        proveedor.setTelefono("123456789");
        proveedor.setEmail("@gmail.com");

        when(proveedorDAO.findById(1L)).thenReturn(java.util.Optional.of(proveedor));
        when(proveedorDAO.save(proveedor)).thenReturn(proveedor);

        Proveedor actual = proveedorService.update(1L, proveedor);
        assertEquals(proveedor.getNombre(), actual.getNombre());
    }

}
