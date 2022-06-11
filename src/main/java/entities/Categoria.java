package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @Column(name = "categoriaId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoriaId;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "dificultad", nullable = false)
    private int dificultad;

    @OneToMany(mappedBy = "categoria")
    private Set<Pregunta> preguntas;

    public Categoria() {
    }

    public Categoria(String categoria, int dificultad) {
        this.categoria = categoria;
        this.dificultad = dificultad;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
}
