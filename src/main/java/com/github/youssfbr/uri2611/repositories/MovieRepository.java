package com.github.youssfbr.uri2611.repositories;

import com.github.youssfbr.uri2611.entities.Movie;
import com.github.youssfbr.uri2611.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query( nativeQuery = true,
            value = "SELECT m.id, m.name " +
                    "FROM movies m " +
                    "INNER JOIN genres g ON m.id_genres = g.id " +
                    "WHERE g.description = :genreName" )
    List<MovieMinProjection> searchBySql(String genreName);
}
