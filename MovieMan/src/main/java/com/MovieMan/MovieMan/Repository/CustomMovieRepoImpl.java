package com.MovieMan.MovieMan.Repository;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


public class CustomMovieRepoImpl implements CustomMovieRepo{

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public MovieEntity addReviewToMovie(String movieId, ReviewEntity review) {
        Query query = new Query(Criteria.where("id").is(movieId));
        Update update = new Update().push("reviews",review);
        mongoTemplate.updateFirst(query,update,MovieEntity.class);
        return mongoTemplate.findById(movieId,MovieEntity.class);
    }
}
