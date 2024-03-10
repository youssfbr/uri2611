package com.github.youssfbr.uri2611;

import com.github.youssfbr.uri2611.dtos.MovieMinDTO;
import com.github.youssfbr.uri2611.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	private final MovieRepository movieRepository;

    public Uri2611Application(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final List<MovieMinDTO> resultSql = movieRepository.searchBySql("Action")
				.stream()
				.map(MovieMinDTO::new)
				.toList();

		final List<MovieMinDTO> resultJpql = movieRepository.searchByJpql("Action");

		System.out.println("\n*** SQL *******************");
		for (MovieMinDTO obj : resultSql) {
			System.out.println(obj);
		}

		System.out.println("\n*** JPQL *******************");
		for (MovieMinDTO obj : resultJpql) {
			System.out.println(obj);
		}

		System.out.println();
	}
}
