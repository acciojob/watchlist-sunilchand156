package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    String addMovie( Movie movie)

    {
        return movieRepository.addMovie(movie);
    }

    String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    Movie getMovieByName(String name) {
        return movieRepository.getmovie(name);
    }

    Director getDirectorByName(String name) {
        return movieRepository.getdirector(name);
    }

    String addMovieDirectorPair(String mvName, String dirName) {
        return movieRepository.addpair(mvName, dirName);
    }

    List getAllMovies() {
        return movieRepository.getAllMovies();
    }

    String deleteDirectorByName(String dirName) {
        return movieRepository.deleteDirectorByName(dirName);
    }

    String deleteAllDirectors() {
        return movieRepository.deleteAllDirectors();
    }

    List getMoviesByDirectorName(String dirName) {
        return movieRepository.getMoviesByDirectorName(dirName);
    }

    String getDirectorByMovieName(String mvName) {
        return movieRepository.getDirectorByMovieName(mvName);
    }

    List<String> findAllTopRatedMovies() {
        return movieRepository.findAllTopRatedMovies();
    }


}