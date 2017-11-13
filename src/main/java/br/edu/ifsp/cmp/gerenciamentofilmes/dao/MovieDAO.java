package br.edu.ifsp.cmp.gerenciamentofilmes.dao;

import br.edu.ifsp.cmp.gerenciamentofilmes.models.Movie;
import br.edu.ifsp.cmp.gerenciamentofilmes.utils.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MovieDAO {

    public void insert(Movie m){
        EntityManager em = ConnectionFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }

    public void remove(Movie m){
        EntityManager em = ConnectionFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
    }

    public Movie select(Movie m){
        EntityManager em = ConnectionFactory.getEntityManager();

        em.getTransaction().begin();

        Movie movie = em.find(Movie.class, m.getId());
        em.getTransaction().commit();

        return movie;
    }


}
