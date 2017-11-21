package br.edu.ifsp.cmp.gerenciamentofilmes.app;


import br.edu.ifsp.cmp.gerenciamentofilmes.dao.MovieDAO;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.Movie;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class Application {

    public static void main(String[] args) {

        Movie movie = Movie.builder().name("Man of Steel").year(Short.parseShort("2011")).build();
        Movie movie2 = Movie.builder().name("Man of Justice").year(Short.parseShort("2013")).build();

        log.info(movie.toString());

        MovieDAO movieDAO = new MovieDAO();
        movieDAO.save(movie);
        movieDAO.save(movie2);


        movieDAO.update(movie, movie2.getId());





    }
}
