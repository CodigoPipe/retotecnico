package game;

import entities.Categoria;
import entities.Jugador;
import entities.Pregunta;
import entities.Respuesta;
import repositories.CategoriaRepo;
import repositories.JugadorRepo;
import repositories.PreguntaRepo;
import repositories.RespuestaRepo;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    PreguntaRepo preguntaRepo;
    RespuestaRepo respuestaRepo;
    JugadorRepo jugadorRepo;

    private int ronda;
    private Jugador jugador;
    private int categoriaId;
    private Pregunta pregunta;
    private ArrayList<Respuesta> respuestas;
    private Respuesta respuestaCorrecta;
    private List<Object[]> arregloPreguntas;

    public Juego(Jugador jugador){

        preguntaRepo = new PreguntaRepo();
        respuestaRepo = new RespuestaRepo();
        jugadorRepo = new JugadorRepo();

        this.jugador=jugador;
        this.ronda=1;
        this.categoriaId = 1;
        this.arregloPreguntas = getPreguntasPorCategoriaId(this.categoriaId);
        this.pregunta = getPreguntaRandom(this.arregloPreguntas);
        this.respuestas = getRespuestasPorPreguntaId(this.pregunta.getPreguntaId());

        cargarRespuestas();
        System.out.println("Ingrese respuesta");

    }

    public void siguienteRonda() {
        this.ronda++;
        if (this.ronda > 5) {
            this.ronda = 1;
            this.categoriaId = this.categoriaId++;
        }
        this.arregloPreguntas.remove(this.pregunta);
        this.pregunta = getPreguntaRandom(arregloPreguntas);
        cargarRespuestas();
    }

    public Pregunta getPreguntaRandom(List<Object[]> arreglosDePreguntas) {
        int valorEntero = (int)Math.floor(Math.random()*(arreglosDePreguntas.size()));
        Pregunta pregunta = (Pregunta) arreglosDePreguntas.get(valorEntero)[0];
        System.out.println(pregunta.getPregunta());
        return pregunta;
    }

    private List<Object[]> getPreguntasPorCategoriaId(int categoriaId) {
        return preguntaRepo.traerPreguntasPorCategoria(categoriaId);
    }

    private ArrayList<Respuesta> getRespuestasPorPreguntaId(int preguntaId) {
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        List<Object[]> listaRespuestas = respuestaRepo.traerRespuestasPorPregunta(preguntaId);
        for (Object[] arrayObjeto: listaRespuestas) {
            Respuesta respuesta = (Respuesta) arrayObjeto[0];
            respuestas.add(respuesta);
        }
        return respuestas;
    }

    private void cargarRespuestas() {
        for (int idx = 0; idx < this.respuestas.size(); idx++) {
            Respuesta respuesta = this.respuestas.get(idx);
            if (respuesta.getCorrecta() == 1) {
                this.respuestaCorrecta = respuesta;
            }
            System.out.println(idx+1 + ". " + respuesta.getRespuesta());
        }
    }

    public int getIndexRespuestaCorrecta() {
        return this.respuestas.indexOf(this.respuestaCorrecta);
    }

}
