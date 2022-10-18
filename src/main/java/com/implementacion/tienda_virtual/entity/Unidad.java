package com.implementacion.tienda_virtual.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "unidades")
public class Unidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idunidad")
    private Long id;

    @Column(name = "idproducto")
    private Long idproducto;

    @Column(name = "idproveedor")
    private Long idproveedor;

    @Column(name = "idsucursal")
    private Long idsucursal;

    @ManyToOne
    @JoinColumn(name = "idproducto", updatable = false, insertable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idproveedor", updatable = false, insertable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "idsucursal", updatable = false, insertable = false)
    private Sucursal sucursal;

    @OneToMany(mappedBy = "unidad")
    private Set<FacturaUnidad> facturaUnidades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public Long getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Long idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Long getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Long idsucursal) {
        this.idsucursal = idsucursal;
    }
}
