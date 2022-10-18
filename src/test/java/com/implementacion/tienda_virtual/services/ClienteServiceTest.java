package com.implementacion.tienda_virtual.services;

import com.implementacion.tienda_virtual.dao.IClienteDAO;
import com.implementacion.tienda_virtual.entity.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;




@ExtendWith(SpringExtension.class)
@SpringBootTest
class ClienteServiceTest {

    @MockBean
    private IClienteDAO clienteDAO;

    @Autowired
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setEmail("@gmail.com");
        cliente.setTelefono("123456789");
    }

    @Test
    void findAll() {
        when(clienteDAO.findAll()).thenReturn(Arrays.asList(cliente));
        assertNotNull(clienteService.findAll());
    }

    @Test
    void findById() {
        when(clienteDAO.findById(1L)).thenReturn(java.util.Optional.of(cliente));
        Cliente cliente = clienteService.findById(1L);
        assertNotNull(cliente);
    }

    @Test
    void save() throws Exception {
        when(clienteDAO.save(cliente)).thenReturn(cliente);
        assertNotNull(clienteService.save(cliente));

        Cliente actual = clienteService.save(cliente);
        assertEquals(cliente.getNombre(), actual.getNombre());
    }


    @Test
    void delete() {
        clienteService.delete(1L);
        verify(clienteDAO).deleteById(1L);
    }

    @Test
    void update() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setEmail("@gmail.com");
        cliente.setTelefono("123456789");

        when(clienteDAO.findById(1L)).thenReturn(java.util.Optional.of(cliente));
        when(clienteDAO.save(cliente)).thenReturn(cliente);

        Cliente actual = clienteService.update(1L, cliente);
        assertEquals(cliente.getNombre(), actual.getNombre());
    }

}