package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categorias {

    @Id
    @Column(name = "categoriaId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoriaId;

    @Column(name = "categoria",nullable = false)
    private String categoria;

    @Column(name = "dificultdad",nullable = false)
    private int dificultad;

    public Categorias(String categoria, int dificultad) {
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
