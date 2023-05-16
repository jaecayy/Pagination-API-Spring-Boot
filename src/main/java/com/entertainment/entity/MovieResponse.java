package com.entertainment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    private List<Movie> movieList;
    private Integer pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
