package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IUnidadDAO;
import com.implementacion.tienda_virtual.entity.Sucursal;
import com.implementacion.tienda_virtual.entity.Unidad;
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
class UnidadServiceTest {

    @MockBean
    private IUnidadDAO unidadDAO;

    @Autowired
    private UnidadService unidadService;

    private Unidad unidad;

    @BeforeEach
    public void setUp() {
        unidad = new Unidad();
        unidad.setIdproducto(1L);
        unidad.setIdproveedor(1L);
        unidad.setIdsucursal(1L);
    }

    @Test
    void findAll() {
        when(unidadDAO.findAll()).thenReturn(List.of(unidad));
        assertThat(unidadService.findAll()).isNotNull();
    }

    @Test
    void findById() {
        when(unidadDAO.findById(1L)).thenReturn(java.util.Optional.of(unidad));
        Unidad unidad = unidadService.findById(1L);
        assertNotNull(unidad);
    }

    @Test
    void save() {
        when(unidadDAO.save(unidad)).thenReturn(unidad);
        assertNotNull(unidadService.save(unidad));
    }

    @Test
    void delete() {
        unidadService.delete(unidad.getId());
        verify(unidadDAO).deleteById(unidad.getId());
    }

    @Test
    void update() {
        unidad = new Unidad();
        unidad.setIdproducto(2L);
        unidad.setIdproveedor(2L);
        unidad.setIdsucursal(2L);

        when(unidadDAO.findById(1L)).thenReturn(java.util.Optional.of(unidad));
        when(unidadDAO.save(unidad)).thenReturn(unidad);

        Unidad actual = unidadService.update(1L, unidad);
        assertEquals(unidad.getIdproducto(), actual.getIdproducto());
    }
}
