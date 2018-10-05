package com.stackroute.moviecruiserapp.service;

import com.stackroute.moviecruiserapp.domain.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("impl2")
public class MovieServiceImpl2 implements MovieService {
    @Override
    public List<Movie> getAllMovies() {
        System.out.println("Retrieving movies from aws");
        return null;
    }

    @Override
    public Movie getMovieById(int id) {
        System.out.println(id);
        return null;
    }

    @Override
    public Movie getMovieByTitle(String title) {
        System.out.println(title);
        return null;
    }

    @Override
    public List<Movie> deleteMovie(int id) {
        System.out.println(id);
        return null;
    }

    @Override
    public Movie updateMovie(int id,String comments) {
        System.out.println(id);
        return null;
    }

    @Override
    public Movie addMovie(Movie movie) {
        System.out.println(movie);
        return movie;
    }
}
