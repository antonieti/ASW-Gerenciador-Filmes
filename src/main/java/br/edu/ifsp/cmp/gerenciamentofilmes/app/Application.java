package br.edu.ifsp.cmp.gerenciamentofilmes.app;

import br.edu.ifsp.cmp.gerenciamentofilmes.models.Movie;
import br.edu.ifsp.cmp.gerenciamentofilmes.utils.ConnectionFactory;
import lombok.extern.log4j.Log4j2;

import javax.persistence.EntityManager;

@Log4j2
public class Application {

    public static void main(String[] args) {

        Movie movie = Movie.builder().name("Man of Steel").year(Short.parseShort("2011")).build();
        EntityManager em = ConnectionFactory.getEntityManager();
        log.info(movie.toString());

        movie.insertMovie();

        System.out.print(movie);

        em.getTransaction().begin();
        em.remove(movie);
        em.getTransaction().commit();
    }
}
