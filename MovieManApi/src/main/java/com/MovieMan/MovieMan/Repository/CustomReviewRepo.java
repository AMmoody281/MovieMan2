package com.MovieMan.MovieMan.Repository;

import com.MovieMan.MovieMan.Model.ReviewEntity;

public interface CustomReviewRepo {
    public ReviewEntity saveReview(ReviewEntity reviewEntity);
}
