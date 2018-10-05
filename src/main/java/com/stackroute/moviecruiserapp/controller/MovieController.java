package com.stackroute.moviecruiserapp.controller;

import com.stackroute.moviecruiserapp.domain.Movie;
import com.stackroute.moviecruiserapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviecruiserapp.exceptions.MovieNotFoundException;
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
import java.util.Optional;

@RestController
@RequestMapping(value="/movie-api/v1")
public class MovieController {
    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value="/movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try {
            Movie saveduser = movieService.addMovie(movie);
            responseEntity = new ResponseEntity<Movie>(saveduser, HttpStatus.OK);
        }
        catch (MovieAlreadyExistsException ex){
            responseEntity = new ResponseEntity<String>("Movie already exists",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping(value="/movie")
    public ResponseEntity<?> getAllMovies(){
        List<Movie> movieList= movieService.getAllMovies();
        ResponseEntity responseEntity=new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
        return responseEntity;
    }
    @PostMapping(value="/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable(value="title") String title) {
        ResponseEntity responseEntity;
        try {
            Movie saveduser = movieService.getMovieByTitle(title);
            responseEntity = new ResponseEntity<Movie>(saveduser, HttpStatus.OK);
        }
        catch (MovieNotFoundException ex){
            responseEntity = new ResponseEntity<String>("No such title",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value="id") int movieId){
        ResponseEntity responseEntity;
        try {
           List<Movie> saveduser = movieService.deleteMovie(movieId);
            responseEntity = new ResponseEntity<List<Movie>>(saveduser, HttpStatus.OK);
        }
        catch (MovieNotFoundException ex){
            responseEntity = new ResponseEntity<String>("No such id",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable(value="id") int movieId,@RequestBody String comments){
        ResponseEntity responseEntity;
        try {
            Movie saveduser = movieService.updateMovie(movieId,comments);
            responseEntity = new ResponseEntity<Movie>(saveduser, HttpStatus.OK);
        }
        catch (MovieNotFoundException ex){
            responseEntity = new ResponseEntity<String>("No such id",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    }
