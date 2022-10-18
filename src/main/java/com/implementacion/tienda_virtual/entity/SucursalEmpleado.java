package com.implementacion.tienda_virtual.entity;

import com.implementacion.tienda_virtual.composite_id.SucursalEmpleadoID;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sucursalesempleados")
public class SucursalEmpleado implements Serializable {

    @EmbeddedId
    private SucursalEmpleadoID id;

    @ManyToOne
    @MapsId("idsucursal")
    @JoinColumn(name = "idsucursal", insertable = false, updatable = false)
    private Sucursal sucursal;

    @ManyToOne
    @MapsId("idempleado")
    @JoinColumn(name = "idempleado", insertable = false, updatable = false)
    private Empleado empleado;


    public SucursalEmpleado() {
    }

    public SucursalEmpleado(Sucursal sucursal, Empleado empleado) {
        this.sucursal = sucursal;
        this.empleado = empleado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public SucursalEmpleadoID getId() {
        return id;
    }

    public void setId(SucursalEmpleadoID id) {
        this.id = id;
    }
}
