package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.dao.IClienteDAO;
import com.implementacion.tienda_virtual.entity.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {


    private MockMvc mockMvc;

    @Mock
    private IClienteDAO clienteDAO;

    @InjectMocks
    private ClienteController clienteController;

    private JacksonTester<ClienteController> json;

    @BeforeEach
    void setUp() {
//        Cliente cliente1 = new Cliente();
//        cliente1.setNombre("Juan");
//        cliente1.setApellido("Perez");
//        cliente1.setTelefono("123456789");
//        cliente1.setEmail("gmail.com");
//
//        Cliente cliente2 = new Cliente();
//        cliente2.setNombre("Juan");
//        cliente2.setApellido("Perez");
//        cliente2.setTelefono("123456789");
//        cliente2.setEmail("gmail.com");
    }

    @Test
    void findAll() {

    }

    @Test
    void findByID() {
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }
}