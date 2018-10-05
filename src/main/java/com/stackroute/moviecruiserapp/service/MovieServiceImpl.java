package com.stackroute.moviecruiserapp.service;

import com.stackroute.moviecruiserapp.domain.Movie;
import com.stackroute.moviecruiserapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviecruiserapp.exceptions.MovieNotFoundException;
import com.stackroute.moviecruiserapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
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


    public Optional<Movie> getMovieById(int id) throws MovieNotFoundException {
        Optional<Movie> movie;
        movie=movieRepository.findById(id);
        if(!movie.isPresent())
            throw new MovieNotFoundException(id);
        return movie;
    }

    public Movie getMovieByTitle(String title) throws MovieNotFoundException {
//        Optional<Movie> movie;
//        List<Movie> movieList=getAllMovies();
//        for(Movie movie2:movieList){
//            if(movie2.getTitle().equals(title))
//                return movie2;
//        }
        return movieRepository.getMovieByTitle(title);
       // throw new MovieNotFoundException(title);
    }



    public List<Movie> deleteMovie(int id) throws MovieNotFoundException {
        if(!movieRepository.existsById(id))
            throw new MovieNotFoundException(id);
        Optional<Movie> movie1=getMovieById(id);
        movieRepository.delete(movie1.get());
        return getAllMovies();
    }


    public Movie updateMovie(int id,String comments) throws MovieNotFoundException {

        if(!movieRepository.existsById(id))
            throw new MovieNotFoundException(id);
        Optional<Movie> movie1=getMovieById(id);
        movie1.get().setComments(comments);
        Movie savedMovie=movieRepository.save(movie1.get());
        return savedMovie;
    }


    public Movie addMovie(Movie movie) throws MovieAlreadyExistsException {
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
