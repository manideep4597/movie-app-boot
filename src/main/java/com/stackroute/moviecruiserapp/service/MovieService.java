package com.stackroute.moviecruiserapp.service;

import com.stackroute.moviecruiserapp.domain.Movie;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieService {
    //@Query(value="select * from Movie",nativeQuery = true)
    public List<Movie> getAllMovies();
    //@Query(value="select * from Movie o where o.id=?1",nativeQuery = true)
    public Movie getMovieById(int id);
    //@Query(value="select o from Movie o where o.title = :title",nativeQuery = true)
    public Movie getMovieByTitle(String title);
    //@Query(value="delete from Movie o where o=?1",nativeQuery = true)
    public List<Movie> deleteMovie(int id);
    public Movie updateMovie(int id,String comments);
    public Movie addMovie(Movie movie);
}
