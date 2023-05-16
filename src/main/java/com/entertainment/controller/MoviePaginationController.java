package com.entertainment.controller;

import com.entertainment.entity.Movie;
import com.entertainment.entity.MovieResponse;
import com.entertainment.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entertainment.utils.AppConstant;

@RestController
@RequestMapping(value="/movie")
public class MoviePaginationController {

    @Autowired
    private MovieService movieService;

    @PostMapping(value="/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.createMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAllMovies")
    public MovieResponse getAllMovies(
            @RequestParam(value = "pageNo", defaultValue = AppConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstant.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = AppConstant.DEFAULT_SORT_DIRECTION, required = false) String sortOrder
    ){
        return movieService.getAllMovie(pageNo,pageSize,sortBy,sortOrder);
    }
}
