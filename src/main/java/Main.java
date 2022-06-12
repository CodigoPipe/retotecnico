import entities.Jugador;
import game.Juego;
import repositories.JugadorRepo;

import java.util.ArrayList;
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

            Jugador jugadorActual = new Jugador(nombreJugador,0);



            Juego juego = new Juego(jugadorActual);
            int ans = sc.nextInt();

            boolean esCorrecta = ans-1 == juego.getIndexRespuestaCorrecta();

            while (esCorrecta) {
                System.out.println("\nCorrecto");

                boolean seTermino = juego.siguienteRonda();

                if(seTermino){
                    esCorrecta = false;
                } else{
                    ans = sc.nextInt();
                    esCorrecta = ans-1 == juego.getIndexRespuestaCorrecta();
                }
            }

            sc.close();

            JugadorRepo finJugador = new JugadorRepo();
            finJugador.crearJugador(juego.getJugador());

            ArrayList<Jugador> historicoJugadores = finJugador.listarJugadores();

            String leftAlignFormat = "| %-15s | %-4d |%n";

            System.out.format("+-----------------+------+%n");
            System.out.format("| NOMBRE     | PUNTAJE   |%n");
            System.out.format("+-----------------+------+%n");
            for(Jugador jugador: historicoJugadores){
                System.out.format(leftAlignFormat,jugador.getNombre(),jugador.getPuntaje());
            }
            System.out.format("+-----------------+------+%n");
        }

        System.out.println("Juego terminado");
    }
}
