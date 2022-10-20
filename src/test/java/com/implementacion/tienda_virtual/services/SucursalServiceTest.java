package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.ISucursalDA;
import com.implementacion.tienda_virtual.entity.Sucursal;
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
public class SucursalServiceTest {

    @MockBean
    private ISucursalDA sucursalDA;

    @Autowired
    private SucursalService sucursalService;

    private Sucursal sucursal;

    @BeforeEach
    public void setUp() {
        sucursal = new Sucursal();
        sucursal.setNombre("sucursal 1");
        sucursal.setDireccion("Introduzca direccion");

    }

    @Test
    void findAll() {
        when(sucursalDA.findAll()).thenReturn(List.of(sucursal));
        assertThat(sucursalService.findAll()).isNotNull();
    }


    @Test
    void findById() {
        when(sucursalDA.findById(1L)).thenReturn(java.util.Optional.of(sucursal));
        Sucursal sucursal = sucursalService.findById(1L);
        assertNotNull(sucursal);
    }

    @Test
    void save() {
        when(sucursalDA.save(sucursal)).thenReturn(sucursal);
        assertNotNull(sucursalService.save(sucursal));
    }

    @Test
    void delete() {
        sucursalService.delete(sucursal.getId());
        verify(sucursalDA).deleteById(sucursal.getId());
    }

    @Test
    void update() {
        sucursal = new Sucursal();
        sucursal.setNombre("sucursal 1");
        sucursal.setDireccion("Introduzca direccion");

        when(sucursalDA.findById(1L)).thenReturn(java.util.Optional.of(sucursal));
        when(sucursalDA.save(sucursal)).thenReturn(sucursal);

        Sucursal actual = sucursalService.update(1L, sucursal);
        assertEquals(sucursal.getNombre(), actual.getNombre());
    }
}
