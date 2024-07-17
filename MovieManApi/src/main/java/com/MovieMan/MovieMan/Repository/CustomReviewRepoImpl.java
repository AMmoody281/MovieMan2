package com.MovieMan.MovieMan.Repository;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CustomReviewRepoImpl implements CustomReviewRepo{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired MovieRepository movieRepository;

    public ReviewEntity saveReview(ReviewEntity review){
        ReviewEntity savedReview = mongoTemplate.save(review);

        return savedReview;
    }
}
