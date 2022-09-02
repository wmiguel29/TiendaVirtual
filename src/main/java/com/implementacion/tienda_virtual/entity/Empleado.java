package com.implementacion.tienda_virtual.entity;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleados")
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "salario")
    private int salario;

    @Column(name = "horarioTrabajo")
    private String horarioTrabajo;

    @Column(name = "isVendedor")
    private boolean isVendedor;
}
