package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "preguntas")
public class Preguntas {

    @Id
    @Column(name = "preguntasId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int preguntasId;

    @Column(name = "pregunta",nullable = false)
    private String pregunta;

    @Column(name = "categoriaId",nullable = false)
    private int categoriaId;

    public Preguntas(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getPreguntasId() {
        return preguntasId;
    }


    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

}
