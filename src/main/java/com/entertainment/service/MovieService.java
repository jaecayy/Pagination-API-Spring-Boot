package com.entertainment.service;


import com.entertainment.entity.Movie;
import com.entertainment.entity.MovieResponse;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    Movie createMovie(Movie movie);

    MovieResponse getAllMovie(int pageNo, int pageSize , String sortBy , String sortOrder);
}
