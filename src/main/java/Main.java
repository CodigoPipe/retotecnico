import entities.Jugador;
import game.Juego;

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
        Juego nuevoJuego = new Juego(jugadorActual);





    }
}
