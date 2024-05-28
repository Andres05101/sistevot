package com.solucionesvirtual.sistevoto.service;

import jakarta.persistence.*;

public class TipoUser {
        private String copropiedad;
        private Integer administrador;
        private Integer activo;

        public TipoUser() {
        }

        public TipoUser(String copropiedad, Integer administrador, Integer activo) {
            this.copropiedad = copropiedad;
            this.administrador = administrador;
            this.activo = activo;
        }

        public String getCopropiedad() {
            return copropiedad;
        }

        public void setCopropiedad(String copropiedad) {
            this.copropiedad = copropiedad;
        }

        public Integer getAdministrador() {
            return administrador;
        }

        public void setAdministrador(Integer administrador) {
            this.administrador = administrador;
        }

        public Integer getActivo() {
            return activo;
        }

        public void setActivo(Integer activo) {
            this.activo = activo;
        }
    }