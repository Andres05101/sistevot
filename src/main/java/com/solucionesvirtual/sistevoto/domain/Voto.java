package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Voto")
@IdClass(VotoId.class)
public class Voto {
    @Id
    @Column(name = "propiedad")
    private String propiedad;
    @Id
    @Column(name = "pregunta")
    private Integer pregunta;
    @Column(name = "respuesta")
    private Integer respuesta;
    @ManyToOne
    @JoinColumn(name = "propiedad", referencedColumnName = "id_copropiedad", insertable = false, updatable = false)
    private Copropiedad copropiedad;
    @ManyToOne
    @JoinColumn(name = "pregunta", referencedColumnName = "id_pregunta", insertable = false, updatable = false)
    private Pregunta pregunta_voto;
    @ManyToOne
    @JoinColumn(name = "respuesta", referencedColumnName = "id_respuesta", insertable = false, updatable = false)
    private Respuesta respuesta_voto;
    public Voto() {
    }
    public Voto(String propiedad, Integer pregunta, Integer respuesta, Copropiedad copropiedad, Pregunta pregunta_voto, Respuesta respuesta_voto) {
        this.propiedad = propiedad;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.copropiedad = copropiedad;
        this.pregunta_voto = pregunta_voto;
        this.respuesta_voto = respuesta_voto;
    }
    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }
    public Integer getPregunta() {
        return pregunta;
    }
    public void setPregunta(Integer pregunta) {
        this.pregunta = pregunta;
    }
    public Integer getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(Integer respuesta) {
        this.respuesta = respuesta;
    }
    public Copropiedad getCopropiedad() {
        return copropiedad;
    }
    public void setCopropiedad(Copropiedad copropiedad) {
        this.copropiedad = copropiedad;
    }
    public Pregunta getPregunta_voto() {
        return pregunta_voto;
    }
    public void setPregunta_voto(Pregunta pregunta_voto) {
        this.pregunta_voto = pregunta_voto;
    }
    public Respuesta getRespuesta_voto() {
        return respuesta_voto;
    }
    public void setRespuesta_voto(Respuesta respuesta_voto) {
        this.respuesta_voto = respuesta_voto;
    }
}
@Embeddable
class VotoId implements Serializable {
    private String propiedad;
    private Integer pregunta;
    public VotoId() {
    }
    public VotoId(String propiedad, Integer pregunta) {
        this.propiedad = propiedad;
        this.pregunta = pregunta;
    }
    public String getPropiedad() {
        return propiedad;
    }
    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }
    public Integer getPregunta() {
        return pregunta;
    }
    public void setPregunta(Integer pregunta) {
        this.pregunta = pregunta;
    }
}