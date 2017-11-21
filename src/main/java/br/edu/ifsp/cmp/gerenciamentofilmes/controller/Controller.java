package br.edu.ifsp.cmp.gerenciamentofilmes.controller;

import br.edu.ifsp.cmp.gerenciamentofilmes.dao.MovieDAO;
import br.edu.ifsp.cmp.gerenciamentofilmes.dao.MovieListDAO;
import br.edu.ifsp.cmp.gerenciamentofilmes.dao.ProducerDAO;
import br.edu.ifsp.cmp.gerenciamentofilmes.dao.UserDAO;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.Movie;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.MovieList;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.Producer;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.User;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List loadMovies(long user) {
        MovieListDAO mlDAO = new MovieListDAO();
        return mlDAO.findFromUser(user);
    }

    public List watchedMovie(long user) {
        List<MovieList> listML = loadMovies(user);
        List<Movie> movies = new ArrayList<>();
        for (MovieList m : listML) {
            if (m.isWatched()) {
                MovieDAO mDAO = new MovieDAO();
                movies.add((Movie) mDAO.findById(m.getId()));
            }
        }

        return movies;

    }

    public List notWatchedMovie(Long user) {
        List<MovieList> listML = loadMovies(user);
        List<Movie> movies = new ArrayList<>();
        for (MovieList m : listML) {
            if (!m.isWatched()) {
                MovieDAO mDAO = new MovieDAO();
                movies.add((Movie) mDAO.findById(m.getId()));
            }
        }

        return movies;

    }

    public void removeMovie(String name, Long user) {
        MovieDAO movieDAO = new MovieDAO();
        Movie aux = findMovieUser(name, user);
        movieDAO.remove(aux);
    }

    private Movie findMovieUser(String name, Long user) {
        MovieListDAO mlDAO = new MovieListDAO();
        Movie aux = null;
        List<MovieList> movieLists = loadMovies(user);
        for (MovieList m : movieLists) {
            if (m.getName().equalsIgnoreCase(name)) {
                aux = m.getMovie();
                break;
            }

        }

        return aux;
    }

    private MovieList findMovieListUser(String name, Long user) {
        MovieListDAO mlDAO = new MovieListDAO();
        MovieList aux = null;
        List<MovieList> movieLists = loadMovies(user);
        for (MovieList m : movieLists) {
            if (m.getName().equalsIgnoreCase(name)) {
                aux = m;
                break;
            }

        }

        return aux;
    }

    public Movie findMovieByName(String name) {
        MovieDAO movieDAO = new MovieDAO();
        Movie movie = movieDAO.findByName(name);
        return movie;
    }

    public void saveMovie(String producerName, String movie, Short year, User user) {
        Producer producer = Producer.builder().name(producerName).build();
        ProducerDAO pDAO = new ProducerDAO();
        pDAO.save(producer);

        Movie movie1 = Movie.builder().name(movie).year(year).producer(producer).build();
        MovieDAO movieDAO = new MovieDAO();
        movieDAO.save(movie1);

        MovieList ml = MovieList.builder().name(movie1).user(user).build();
        MovieListDAO mlDAO = new MovieListDAO();
        mlDAO.save(ml);

    }

    public void rateMovie(Movie movie, Long user, Long rate) {
        MovieList m = findMovieListUser(movie.getName(), user);
        m.setRate(rate);
        m.setWatched(true);
        MovieListDAO movieListDAO = new MovieListDAO();
        movieListDAO.update(m, movie.getId());
    }

    public void saveUser(String name, String userName, String password){
        User user = User.builder().name(name).userName(userName).password(password).build();
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
    }

    public User login(String userName, String password){
        UserDAO userDAO = new UserDAO();
        User user = (User) userDAO.findFrom("userName", userName);
        if(user.getPassword().equalsIgnoreCase(password)){
            return user;
        }

        return null;
    }



}
