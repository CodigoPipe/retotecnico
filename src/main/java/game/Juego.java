package game;

import entities.Jugador;
import entities.Pregunta;
import entities.Respuesta;
import repositories.JugadorRepo;
import repositories.PreguntaRepo;
import repositories.RespuestaRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private ArrayList<Pregunta> arregloPreguntas;

    //constructor que usaremos en el main para inciar el juego, lanzara primera pregunta
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

    }

    //metodo con la logica del juego, lanzara una nueva pregunta de acuerdo a la respuesta anterior y sumara puntaje
    public boolean siguienteRonda() {

        if(this.categoriaId >5){
            System.out.println("Felicidades Ganaste, puedes llevarte el premio de "+ this.jugador.getPuntaje() +" Dolares");
            return true;
        }

        this.jugador.setPuntaje(this.jugador.getPuntaje() + 100);
        this.ronda++;

        System.out.println("Puntaje Actual: "+ this.jugador.getPuntaje()+"\n");

        System.out.println("Quieres retirarte con tus ganancias?, escribe si o no y puslsa enter");
        Scanner retiro = new Scanner(System.in);
        String meRetiro = retiro.nextLine();
        //retiro.close();

        if(meRetiro.equalsIgnoreCase("si")){
            System.out.println(" te vas con un total de " + this.jugador.getPuntaje()+ " dolares");
            return true;
        }

        if (this.ronda > 5) {
            this.ronda = 1;
            this.categoriaId = this.categoriaId+1;
            this.arregloPreguntas = getPreguntasPorCategoriaId(this.categoriaId);
        }

        this.arregloPreguntas.remove(this.pregunta);
        this.pregunta = getPreguntaRandom(arregloPreguntas);
        this.respuestas = getRespuestasPorPreguntaId(this.pregunta.getPreguntaId());
        cargarRespuestas();
        return false;

    }

    //getters y setters
    public Pregunta getPreguntaRandom(ArrayList<Pregunta> arreglosDePreguntas) {
        int valorEntero = (int)Math.floor(Math.random()*(arreglosDePreguntas.size()));
        Pregunta pregunta = arreglosDePreguntas.get(valorEntero);
        System.out.println(pregunta.getPregunta());
        return pregunta;
    }

    private ArrayList<Pregunta> getPreguntasPorCategoriaId(int categoriaId) {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        List<Object[]> listaPreguntas = preguntaRepo.traerPreguntasPorCategoria(categoriaId);
        for (Object[] arrayObjeto: listaPreguntas) {
            Pregunta pregunta = (Pregunta) arrayObjeto[0];
            preguntas.add(pregunta);
        }
        return preguntas;
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
        System.out.println("\nIngrese respuesta");
    }

    public int getIndexRespuestaCorrecta() {
        return this.respuestas.indexOf(this.respuestaCorrecta);
    }

    public Jugador getJugador(){
        return this.jugador;
    }

}
