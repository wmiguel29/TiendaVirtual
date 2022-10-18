package com.implementacion.tienda_virtual.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idfactura")
    private Long idF;

    @Column(name = "idcliente")
    private Long idC;

    @Column(name = "idvendedor")
    private Long idV;

    @Column(name = "date")
    private Date fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcliente", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idvendedor", insertable = false, updatable = false)
    private Empleado empleado;

    @OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
    private List<FacturaUnidad> facturaUnidades;


    public Long getIdF() {
        return idF;
    }

    public void setIdF(Long idF) {
        this.idF = idF;
    }

    public Long getIdC() {
        return idC;
    }

    public void setIdC(Long idC) {
        this.idC = idC;
    }

    public Long getIdV() {
        return idV;
    }

    public void setIdV(Long idV) {
        this.idV = idV;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
