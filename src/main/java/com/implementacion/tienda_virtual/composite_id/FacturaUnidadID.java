package com.implementacion.tienda_virtual.composite_id;

import com.implementacion.tienda_virtual.entity.FacturaUnidad;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FacturaUnidadID implements Serializable {

    @Column(name = "idfactura")
    private Long idFactura;

    @Column(name = "idunidad")
    private Long idUnidad;

    public FacturaUnidadID() {
    }

    public FacturaUnidadID(Long idFactura, Long idUnidad) {
        this.idFactura = idFactura;
        this.idUnidad = idUnidad;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacturaUnidadID that = (FacturaUnidadID) o;

        return idFactura.equals(that.idFactura) && idUnidad.equals(that.idUnidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFactura, idUnidad);
    }
}
