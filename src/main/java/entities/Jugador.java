package entities;


import javax.persistence.*;
import java.util.logging.Level;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @Column(name = "jugadorId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jugadorId;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "puntaje",nullable = false)
    private int puntaje;

    public Jugador(){

    }

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    }



    public int getJugadorId() {
        return jugadorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
