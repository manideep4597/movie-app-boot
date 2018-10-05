package com.stackroute.moviecruiserapp.service;

import com.stackroute.moviecruiserapp.domain.Movie;
import com.stackroute.moviecruiserapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviecruiserapp.exceptions.MovieNotFoundException;
import com.stackroute.moviecruiserapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("impl1")
@Primary
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }


    public Movie getMovieById(int id) {
        Optional<Movie> movie;
        movie=movieRepository.findById(id);
        if(!movie.isPresent())
            throw new MovieNotFoundException(id);
        return movie.get();
    }

    public Movie getMovieByTitle(String title) {
//        Optional<Movie> movie;
//        List<Movie> movieList=getAllMovies();
//        for(Movie movie2:movieList){
//            if(movie2.getTitle().equals(title))
//                return movie2;
//        }
        System.out.println(movieRepository.getMovieByTitle(title));
        return movieRepository.getMovieByTitle(title);
        //throw new MovieNotFoundException(title);
    }



    public List<Movie> deleteMovie(int id) {
        if(!movieRepository.existsById(id))
            throw new MovieNotFoundException(id);
        Movie movie1=getMovieById(id);
        movieRepository.delete(movie1);
        return getAllMovies();
    }


    public Movie updateMovie(int id,String comments) {

        if(!movieRepository.existsById(id))
            throw new MovieNotFoundException(id);
        Movie movie1=getMovieById(id);
        if(movie1!=null){
            movie1.setComments(comments);
        }
        Movie savedMovie=movieRepository.save(movie1);
        return savedMovie;
    }


    public Movie addMovie(Movie movie) {
        List<Movie> movieList=getAllMovies();
        if(movieRepository.existsById(movie.getId()))
            throw new MovieAlreadyExistsException(movie);
//        for(Movie movie2:movieList){
//            if(movie2.getId()==(movie.getId()))
//                throw new MovieAlreadyExistsException(movie);
//        }
        Movie savedMovie=movieRepository.save(movie);
        return savedMovie;
    }
}
