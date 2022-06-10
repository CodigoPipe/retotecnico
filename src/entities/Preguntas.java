package entities;

public class Preguntas {

    private int preguntasId;
    private String pregunta;
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
