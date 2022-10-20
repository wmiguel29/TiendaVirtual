package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IEmpleadoDAO;
import com.implementacion.tienda_virtual.entity.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmpleadoServiceTest {

    @MockBean
    private IEmpleadoDAO empleadoDAO;

    @Autowired
    private EmpleadoService empleadoService;

    private Empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new Empleado();
        empleado.setNombre("Juan");
        empleado.setApellido("Perez");
        empleado.setEmail("@gmail.com");
        empleado.setTelefono("123456789");
        empleado.setSalario(1000);
        empleado.setHorarioTrabajo("8:00-16:00");
        empleado.setVendedor(true);

    }

    @Test
    void findAll() {
        when(empleadoDAO.findAll()).thenReturn(List.of(empleado));
        assertThat(empleadoService.findAll()).isNotNull();
    }
//        empleadoDAO.save(empleado);
//
//        List<Empleado> empleados = empleadoService.findAll();
//
//        assertNotNull(empleados);
//
//        assertThat(empleados.size()).isEqualTo(1);
//
////        verify(empleadoDAO).findAll();
//    }


    @Test
    void findById() {
        when(empleadoDAO.findById(1L)).thenReturn(java.util.Optional.of(empleado));
        Empleado empleado = empleadoService.findById(1L);
        assertNotNull(empleado);
    }

    @Test
    void save() {
        when(empleadoDAO.save(empleado)).thenReturn(empleado);
        assertNotNull(empleadoService.save(empleado));
    }

    @Test
    void delete() {
        empleadoService.delete(empleado.getId());
        verify(empleadoDAO).deleteById(empleado.getId());
    }
}