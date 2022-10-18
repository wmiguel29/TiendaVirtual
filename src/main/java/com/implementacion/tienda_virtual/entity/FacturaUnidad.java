package com.implementacion.tienda_virtual.entity;

import com.implementacion.tienda_virtual.composite_id.FacturaUnidadID;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "facturasunidades")
public class FacturaUnidad implements Serializable {

    @EmbeddedId
    private FacturaUnidadID id;

    @ManyToOne
    @MapsId("idfactura")
    @JoinColumn(name = "idfactura", insertable = false, updatable = false)
    private Factura factura;

    @ManyToOne
    @MapsId("idunidad")
    @JoinColumn(name = "idunidad", insertable = false, updatable = false)
    private Unidad unidad;

    public FacturaUnidad() {
    }

    public FacturaUnidad(Factura factura, Unidad unidad) {
        this.factura = factura;
        this.unidad = unidad;
    }

    public FacturaUnidadID getId() {
        return id;
    }

    public void setId(FacturaUnidadID id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}


