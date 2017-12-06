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
        List<MovieList> movies = new ArrayList<>();
        for (MovieList m : listML) {
            if (m.isWatched()) {
                movies.add(m);
            }
        }

        return movies;

    }

    public List notWatchedMovie(Long user) {
        List<MovieList> listML = loadMovies(user);
        List<MovieList> movies = new ArrayList<>();
        for (MovieList m : listML) {
            if (!(m.isWatched())) {
                movies.add(m);
            }
        }

        return movies;

    }

    public void removeMovie(String name, Long user) {
        MovieDAO movieDAO = new MovieDAO();
        Movie aux = findMovieUser(name, user);
        MovieListDAO mDAO = new MovieListDAO();
        List<MovieList> movieList = mDAO.findFromMovie(aux.getId());
        for (MovieList m : movieList) {
            if(m.getUser().getId()==user){
                mDAO.remove(m);
            }
        }
        movieDAO.remove(aux);
    }

    private Movie findMovieUser(String name, Long user) {
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

    public MovieList getMovieInfo(Movie movie, Long user){
        MovieListDAO mDAO = new MovieListDAO();
        List<MovieList> movies = mDAO.findFromMovie(movie.getId());
        for (MovieList m : movies) {
            if(m.getUser().getId()==user){
                return m;
            }
        }
        return null;
    }

    public void saveMovie(String producerName, String movie, Short year, User user, String genero) {
        Producer producer;
        ProducerDAO pDAO = new ProducerDAO();
        Producer producerExist = (Producer) pDAO.findByName(producerName);
        if(producerExist==null){
             producer = Producer.builder().name(producerName).build();
            pDAO.save(producer);
        }else{
             producer = producerExist;
        }


        Movie movie1 = Movie.builder().name(movie).year(year).producer(producer).build();
        MovieDAO movieDAO = new MovieDAO();
        Movie movieExist = movieDAO.findByName(movie);
        if(movieExist==null){
            movieDAO.save(movie1);
        }else {
            movie1 = movieExist;
        }


        MovieList ml = MovieList.builder().name(movie1).user(user).build();
        MovieListDAO mlDAO = new MovieListDAO();
        mlDAO.save(ml);

    }

    public void rateMovie(Movie movie, Long user, Long rate) {
        MovieList m = findMovieListUser(movie.getName(), user);
        m.setRate(rate);
        m.setWatched(true);
        MovieListDAO movieListDAO = new MovieListDAO();
        movieListDAO.update(m, m.getId());
    }

    public User saveUser(String name, String userName, char[] password){
        User user = User.builder().name(name).userName(userName).password(String.valueOf(password)).build();
        if(saveUser(user)){
            return user;
        }else{
            return null;
        }

    }

    public User login(String userName){
        UserDAO userDAO = new UserDAO();
        User user = (User) userDAO.findFrom(userName);
        return user;
    }

    public boolean verifyPaswword(String userName, char[] password){
        UserDAO userDAO = new UserDAO();
        User user = (User) userDAO.findFrom(userName);
        if(user!=null){
            if(user.getPassword().equalsIgnoreCase(String.valueOf(password))){
                return true;
            }
        }


        return false;
    }

    public boolean saveUser(User user){
        UserDAO ud = new UserDAO();
        if(ud.findFrom(user.getUserName())!=null){
            return false;
        }else{
            ud.save(user);
            return true;
        }
    }



}
