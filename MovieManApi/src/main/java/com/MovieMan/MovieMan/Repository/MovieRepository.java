package com.MovieMan.MovieMan.Repository;


import com.MovieMan.MovieMan.Model.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MovieRepository extends MongoRepository<MovieEntity,String>  {
    @Query("{ 'genre': { $in: [?0] } }")
    List<MovieEntity> findMoviesByGenre(String genre);

    @Query("{ 'title': ?0 }")
    List<MovieEntity> findMoviesByTitle(String title);

    //movies rating greater than or Equal
    @Query("{ 'rating':  {$gt: ?0}    }")
    List<MovieEntity> findMoviesWithRatingGreaterThan(float rating);


}
//parent child documents
// custom query

//use mongo client instead
