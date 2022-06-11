package repositories;

import entities.Pregunta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PreguntaRepo {

    public Pregunta traerPregunta(int idPregunta) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Pregunta.class).
                buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Pregunta pregunta = session.get(Pregunta.class, idPregunta);
            session.getTransaction().commit();
            sessionFactory.close();
            return pregunta;
        } catch (Exception e){
            sessionFactory.close();
            return null;
        }
    }

    public List<Object[]> traerPreguntasPorCategoria(int idCategoria) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Pregunta.class).
                buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            List<Object[]> preguntas = session.createQuery("FROM Pregunta as p INNER JOIN p.categoria WHERE p.categoria.categoriaId = :categoriaId").setParameter("categoriaId", idCategoria).list();
            sessionFactory.close();
            return preguntas;
        } catch (Exception e){
            sessionFactory.close();
            return null;
        }
    }
}
