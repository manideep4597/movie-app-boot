package com.stackroute.moviecruiserapp.repository;

import com.stackroute.moviecruiserapp.domain.Movie;
import com.stackroute.moviecruiserapp.exceptions.MovieNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

//This is integrated test we need DB server
//Find out what are testRunner
@RunWith(SpringRunner.class)
@DataMongoTest
public class MovieRepositoryTest {
    @Autowired
    MovieRepository movieRepository;
    Movie movie;

    @Before
    public void setUp()
    {
        movie = new Movie();
        movie.setId(10);
        movie.setTitle("Rang De Basanti");
        movie.setComments("good movie");
        movie.setLanguage("Hindi");

    }
    @After
    public void tearDown() throws Exception {
        movieRepository.deleteAll();
    }
    @Test
    public void testSaveMovie(){
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertEquals(10,fetchMovie.getId());
    }
    @Test
    public void testSaveMovieFailure(){
        Movie testMovie = new Movie(101,"spiderman","English","4 star");
        movieRepository.save(testMovie);
        movieRepository.save(movie);
        Movie fetchMovie=movieRepository.findById(movie.getId()).get();
        Assert.assertNotSame(fetchMovie,movie);
    }
    @Test
    public void testDeleteMovie(){
        movieRepository.save(movie);
        movieRepository.delete(movie);
        boolean fetchMovie = movieRepository.existsById(movie.getId());
        Assert.assertEquals(false,fetchMovie);
    }
    @Test
    public void testDeleteMovieFailure(){
        Movie testMovie = new Movie(10,"spiderman","English","4 star");
        movieRepository.save(movie);
        movieRepository.save(testMovie);
        movieRepository.delete(movie);
        Optional<Movie> fetchMovie=movieRepository.findById(movie.getId());
        Assert.assertEquals(Optional.empty(),fetchMovie);
    }
    @Test
    public void testGetAllMovie(){
        List<Movie> listold = movieRepository.findAll();
        Movie movie1 = new Movie(10,"Gita Govindam","Telugu","3 star");
        Movie movie2 = new Movie(9,"Bommarillu","Telugu","4 star");
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        List<Movie> listUpdated = movieRepository.findAll();
        Assert.assertEquals(listold.size()+2,listUpdated.size());
    }

}
