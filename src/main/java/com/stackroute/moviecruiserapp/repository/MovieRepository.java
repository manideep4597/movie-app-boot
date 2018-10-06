package com.stackroute.moviecruiserapp.repository;

import com.stackroute.moviecruiserapp.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@EnableJpaRepositories
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query(value="select * from MOVIE o where o.TITLE=:title",nativeQuery = true)
    public Movie getMovieByTitle(@Param("title") String title);
}
