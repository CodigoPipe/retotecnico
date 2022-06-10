package game;

import entities.Categorias;
import entities.Jugador;
import entities.Preguntas;
import entities.Respuestas;

import java.util.ArrayList;

public class Juego {

    private int ronda;
    private Jugador jugador;
    private Categorias categoria;
    private Preguntas pregunta;
    private ArrayList<Respuestas> respuestas;

    public Juego(Jugador jugador){
        this.jugador=jugador;
        this.ronda=0;
        this.categoria = getCategoria();
        this.pregunta = getPrimeraPregunta();
        this.respuestas = getRespuestas(this.pregunta);
    }




}
