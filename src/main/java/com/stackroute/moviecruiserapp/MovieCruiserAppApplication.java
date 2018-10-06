package com.stackroute.moviecruiserapp;

import com.stackroute.moviecruiserapp.domain.Movie;
import com.stackroute.moviecruiserapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MovieCruiserAppApplication implements ApplicationListener<ContextRefreshedEvent>,CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieCruiserAppApplication.class, args);
	}

	private MovieRepository movieRepository;

	public MovieCruiserAppApplication(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		movieRepository.save(new Movie(3,"venom","english","save"));
		movieRepository.save(new Movie(4,"stree","hindi","save"));
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		movieRepository.save(new Movie(1,"la la","english","save"));
		movieRepository.save(new Movie(2,"devadas","telugu","save"));

	}
}
