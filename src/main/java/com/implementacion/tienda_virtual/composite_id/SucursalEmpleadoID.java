package com.implementacion.tienda_virtual.composite_id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SucursalEmpleadoID implements Serializable {



        @Column(name = "idsucursal")
        private Long idSucursal;

        @Column(name = "idempleado")
        private Long idEmpleado;


        public SucursalEmpleadoID() {
        }

        public SucursalEmpleadoID(Long idempleado, Long idsucursal) {
            this.idEmpleado = idempleado;
            this.idSucursal = idsucursal;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SucursalEmpleadoID that = (SucursalEmpleadoID) o;

            return idEmpleado.equals(that.idEmpleado) && idSucursal.equals(that.idSucursal);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idEmpleado, idSucursal);
        }

        public Long getIdSucursal() {
            return idSucursal;
        }

        public void setIdSucursal(Long idSucursal) {
            this.idSucursal = idSucursal;
        }

        public Long getIdEmpleado() {
            return idEmpleado;
        }

        public void setIdEmpleado(Long idEmpleado) {
            this.idEmpleado = idEmpleado;
        }
}
