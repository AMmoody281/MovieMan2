package com.MovieMan.MovieMan.Repository;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ReviewRepository extends MongoRepository<ReviewEntity,String>{

    @Query("{ 'title' : ?0 }")
    public ReviewEntity findByTitle(String title);
}
