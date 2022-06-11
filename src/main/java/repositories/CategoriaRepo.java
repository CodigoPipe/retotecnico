package repositories;

import entities.Categoria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CategoriaRepo {

    public Categoria traerCategoria(int idCategoria) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Categoria categoria = session.get(Categoria.class, idCategoria);
            session.getTransaction().commit();
            sessionFactory.close();
            return categoria;
        } catch (Exception e){
            sessionFactory.close();
            return null;
        }
    }
}
