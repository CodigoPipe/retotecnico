package repositories;

import entities.Jugador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class JugadorRepo {

    public String crearJugador(Jugador jugadorNew) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Jugador.class).
                buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(jugadorNew);
            session.getTransaction().commit();
            sessionFactory.close();
            return "Usuario creado";
        } catch (Exception e){
            sessionFactory.close();
            return "Error al crear usuario";
        }


    }

    public ArrayList<Jugador> listarJugadores() {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Jugador.class).
                buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            ArrayList<Jugador> jugadores = (ArrayList<Jugador>) session.createQuery("FROM Jugador ").list();
            sessionFactory.close();
            return jugadores;
        } catch (Exception e){
            sessionFactory.close();
            return null;
        }


    }



}
