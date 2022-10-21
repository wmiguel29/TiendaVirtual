package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IFacturaDAO;
import com.implementacion.tienda_virtual.entity.Cliente;
import com.implementacion.tienda_virtual.entity.Empleado;
import com.implementacion.tienda_virtual.entity.Factura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacturaServiceTest {
    @MockBean
    private IFacturaDAO facturaDAO;

    @Autowired
    private FacturaService facturaService;

    private Factura factura;

    @BeforeEach
    public void setUp() {
        factura = new Factura();
        factura.setIdC(1L);
        factura.setIdV(1L);
        factura.setCliente(new Cliente());
        factura.setEmpleado(new Empleado());
        factura.setFecha(new Date());
    }

    @Test
    void findAll() {
        when(facturaDAO.findAll()).thenReturn(List.of(factura));
        assertThat(facturaService.findAll()).isNotNull();
    }

    @Test
    void findById() {
        when(facturaDAO.findById(1L)).thenReturn(java.util.Optional.of(factura));
        Factura factura = facturaService.findById(1L);
        assertNotNull(factura);
    }

    @Test
    void save() {
        when(facturaDAO.save(factura)).thenReturn(factura);
        assertNotNull(facturaService.save(factura));
    }

    @Test
    void delete() {
        facturaService.delete(factura.getIdF());
        verify(facturaDAO).deleteById(factura.getIdF());
    }
}
