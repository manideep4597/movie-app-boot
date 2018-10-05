package com.stackroute.moviecruiserapp.exceptions;

import com.stackroute.moviecruiserapp.domain.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(Movie movie) {
        super(movie.getTitle()+" Movie already exists");
    }
}
