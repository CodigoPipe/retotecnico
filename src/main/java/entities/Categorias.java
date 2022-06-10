package entities;

public class Categorias {

    private int categoriaId;
    private String categoria;
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
