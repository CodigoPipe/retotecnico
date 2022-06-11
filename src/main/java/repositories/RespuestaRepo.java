package repositories;

import entities.Respuesta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RespuestaRepo {

    public Respuesta traerRespuesta(int idRespuesta) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Respuesta.class).
                buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Respuesta respuesta = session.get(Respuesta.class, idRespuesta);
            session.getTransaction().commit();
            sessionFactory.close();
            return respuesta;
        } catch (Exception e){
            sessionFactory.close();
            return null;
        }


    }

    public List<Object[]> traerRespuestasPorPregunta(int idPregunta) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Respuesta.class).
                buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            List<Object[]> respuestas = session.createQuery("FROM Respuesta as r INNER JOIN r.pregunta WHERE r.pregunta.preguntaId = :preguntaId").setParameter("preguntaId", idPregunta).list();
            sessionFactory.close();
            return respuestas;
        } catch (Exception e){
            sessionFactory.close();
            return null;
        }
    }
}