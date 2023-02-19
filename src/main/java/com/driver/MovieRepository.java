package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movies=new HashMap<>();
    HashMap<String,Director> directors=new HashMap<>();
    HashMap<String, List<String>> pair=new HashMap<>();

    public String addMovie(Movie movie){
       String mv= movie.getName ();
       movies.put(mv, movie);
       return "Successfully added movie";

    }
    public String addDirector(Director director){
        String dn= director.getName ();
        directors.put(dn, director);
        return "Successfully added director";

}
    public Movie getmovie(String name){
        return movies.get(name);
    }
    public Director getdirector(String name){
        return directors.get(name);
    }

    public String addpair(String mvName,String dirName){
        if(movies.containsKey(mvName) && directors.containsKey(dirName)){
            if(pair.containsKey(dirName))
                pair.get(dirName).add(mvName);
            else {
                ArrayList<String> mv=new ArrayList<>();
                mv.add(mvName);
                pair.put(dirName,mv);
            }
        }
        return "SUCCESSFULLY PAIRED";
    }
    public List getAllMovies(){
        ArrayList<String> mvs=new ArrayList<>();
        for(String s:movies.keySet())
            mvs.add(s);

        return mvs;
    }
    public String deleteDirectorByName(String dirName){
        if(directors.containsKey(dirName))
        {
            if(pair.containsKey(dirName))
            {
                List<String> movies1=pair.get(dirName);
                for(String mv:movies1){
                    movies.remove(mv);
                }
                pair.remove(dirName);
            }
            directors.remove(dirName);
            return "SUCCESSFULLY DELETED ";
        }
        return null;
    }

    public String deleteAllDirectors(){
        ArrayList<String> list=new ArrayList<>();
        for(String s:pair.keySet())
        {
            for(String m:pair.get(s))
                list.add(m);
        }
        for(String i:list)
            movies.remove(i);

        return  "SUCCESSFULLY DELETED ALL DIRECTORS";
    }
    public List getMoviesByDirectorName(String dirName){
        List<String> movieNames=new ArrayList<>();
        if(pair.containsKey(dirName))
            movieNames=(pair.get(dirName));

        return movieNames;
    }
    public String getDirectorByMovieName(String mvName){

        for(String director:pair.keySet()){
            List<String> movies=pair.get(director);
            if(movies.contains(mvName))
                return director;
        }
        return "Not exist";
    }
    public List<String> findAllTopRatedMovies(){
        List<String> movieList = new ArrayList<>();

        for(Movie movie : movies.values()){
            if(movie.getImdbRating() >= 9){
                movieList.add(movie.getName());
            }
        }
        return movieList;
    }

}

