package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "respuestas")
public class Respuestas {

    @Id
    @Column(name = "respuestaId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int respuestaId;

    @Column(name = "respuesta",nullable = false)
    private String respuesta;

    @Column(name = "correcta",nullable = false)
    private int correcta;

    @Column(name = "preguntaId",nullable = false)
    private int preguntaId;

    public Respuestas(String respuesta) {
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

    public int getPreguntaId() {
        return preguntaId;
    }

}
