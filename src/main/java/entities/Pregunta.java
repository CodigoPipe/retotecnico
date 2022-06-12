package entities;

import javax.persistence.*;
import java.util.Set;
import java.util.logging.Level;

@Entity
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @Column(name = "preguntaId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int preguntaId;

    @Column(name = "pregunta", nullable = false)
    private String pregunta;

    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    @OneToMany(mappedBy = "pregunta")
    private Set<Respuesta> respuestas;

    public Pregunta() {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    }

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
