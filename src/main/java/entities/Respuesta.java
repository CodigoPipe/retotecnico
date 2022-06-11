package entities;

import javax.persistence.*;

@Entity
@Table(name = "respuestas")
public class Respuesta {

    @Id
    @Column(name = "respuestaId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int respuestaId;

    @Column(name = "respuesta", nullable = false)
    private String respuesta;

    @Column(name = "correcta", nullable = false)
    private int correcta;

    @ManyToOne
    @JoinColumn(name = "preguntaId")
    private Pregunta pregunta;

    public Respuesta() {

    }

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getRespuestaId() {
        return respuestaId;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }
}
