import entities.Jugador;
import entities.Pregunta;
import entities.Respuesta;
import game.Juego;
import repositories.PreguntaRepo;
import repositories.RespuestaRepo;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

         System.out.println("Bienvenido viajero al juego intelectual 'MILLONARIO'," +
                " este juego consiste en 5 rondas de 5 preguntas cada ronda, a medida " +
                "que avanzas de ronda las preguntas de cultura general subiran de nivel, si estas preparado" +
                " escribe ok y luego presiona enter");

        Scanner sc = new Scanner(System.in);
        String iniciaElJuego = sc.nextLine();
        String nombreJugador = "";

        if(iniciaElJuego.equalsIgnoreCase("OK")){
            System.out.println("Ingresa tu nombre y pulsa Enter");
            nombreJugador = sc.nextLine();
        }

        Jugador jugadorActual = new Jugador(nombreJugador,0);

        Juego juego = new Juego(jugadorActual);

        boolean esValidoJuego = true;

        while (esValidoJuego) {
            int ans = sc.nextInt();
            esValidoJuego = ans-1 == juego.getIndexRespuestaCorrecta();
            System.out.println("Correcto");
            juego.siguienteRonda();
            ans = sc.nextInt();
        }
        System.out.println("Juego temrminado");
    }
}
