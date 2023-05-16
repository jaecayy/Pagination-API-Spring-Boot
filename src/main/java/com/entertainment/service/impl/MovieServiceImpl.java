package com.entertainment.service.impl;

import com.entertainment.entity.Movie;
import com.entertainment.entity.MovieResponse;
import com.entertainment.repository.MovieRepository;
import com.entertainment.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public MovieResponse getAllMovie(int pageNo, int pageSize, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Movie> movies = movieRepository.findAll(pageable);

        List<Movie> listOfMovies = movies.getContent();

        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovieList(listOfMovies);
        movieResponse.setPageNo(movies.getNumber());
        movieResponse.setPageSize(movies.getSize());
        movieResponse.setTotalElements(movies.getTotalElements());
        movieResponse.setTotalPages(movies.getTotalPages());
        movieResponse.setLast(movies.isLast());
        return movieResponse;
    }
}
