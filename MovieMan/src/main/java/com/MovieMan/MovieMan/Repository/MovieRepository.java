package com.MovieMan.MovieMan.Repository;


import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends MongoRepository<MovieEntity, String>, CustomMovieRepo {
    @Query("{ 'genre': { $in: [?0] } }")
    List<MovieEntity> findMoviesByGenre(String genre);

    @Query("{ 'title': ?0 }")
    List<MovieEntity> findMoviesByTitle(String title);

    //movies rating greater than or Equal
    @Query("{ 'rating':  {$gt: ?0}    }")
    List<MovieEntity> findMoviesWithRatingGreaterThan(float rating);

    @Query(value="{'id':?0 }", fields = "{reviews : 1}")
    List<ReviewEntity> findReviewsByMovieId(String movieId);


}
//parent child documents
// custom query

//use mongo client instead
