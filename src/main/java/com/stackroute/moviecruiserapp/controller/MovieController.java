package com.stackroute.moviecruiserapp.controller;

import com.stackroute.moviecruiserapp.domain.Movie;
import com.stackroute.moviecruiserapp.service.MovieService;
import com.stackroute.moviecruiserapp.service.MovieServiceImpl;
import com.stackroute.moviecruiserapp.service.MovieServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/movie-api/v1")
public class MovieController {

    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value="/add")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        Movie savedMovie=movieService.addMovie(movie);
        ResponseEntity<Movie> responseEntity=new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping(value="/movies")
    public ResponseEntity<?> getAllMovies(){
        List<Movie> movieList= movieService.getAllMovies();
        ResponseEntity responseEntity=new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
        return responseEntity;
    }
    @PostMapping(value="/movieName")
    public ResponseEntity<?> getMovieByTitle(@RequestBody Movie movie) {
        Movie savedMovie = movieService.getMovieByTitle(movie.getTitle());
        ResponseEntity<Movie> responseEntity = new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);
        return responseEntity;
    }
    @PostMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value="id") int movieId){
        List<Movie> movieList=movieService.deleteMovie(movieId);
        ResponseEntity responseEntity=new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable(value="id") int movieId,@RequestBody String comments){
        Movie updatedMovie=movieService.updateMovie(movieId,comments);
        ResponseEntity<Movie> responseEntity = new ResponseEntity<Movie>(updatedMovie, HttpStatus.OK);
        return responseEntity;
    }


    }
