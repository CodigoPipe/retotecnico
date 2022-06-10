package entities;

public class Respuestas {

    private int respuestaId;
    private String respuesta;
    private int correcta;
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
