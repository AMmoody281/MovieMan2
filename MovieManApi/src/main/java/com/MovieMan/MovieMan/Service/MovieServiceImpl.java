package com.MovieMan.MovieMan.Service;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import com.MovieMan.MovieMan.Repository.MovieRepository;
import com.MovieMan.MovieMan.Repository.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MovieEntity> findAll() {
        return movieRepository.findAll();
    }

    @Transactional
    @Override
    public ReviewEntity addReviewToMovie(String movieId, ReviewEntity review) {
        ReviewEntity savedReview = reviewRepository.save(review);

        Query query = new Query(Criteria)
        return null;
    }

    @Override
    public Optional<MovieEntity> findById(ObjectId id) {
        return movieRepository.findById(id.toString());
    }

    @Override
    public MovieEntity saveOrUpdateMovie(MovieEntity movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<MovieEntity> searchByGenre(String genreSearch) {
       return movieRepository.findMoviesByGenre(genreSearch);
//        List<MovieEntity> results = new ArrayList<>();
//        for(MovieEntity movie:findAll()){
//            for(String genre: movie.getGenre()){
//                if (genre.equals(genreSearch)){
//                    results.add(movie);
//                    break;
//                };
//            }
//        }
//        return results;
    }

    @Override
    public List<MovieEntity> searchByTitle(String titleSearch) {
        return movieRepository.findMoviesByTitle(titleSearch);
//        List<MovieEntity> results = new ArrayList<>();
//        for(MovieEntity movie:findAll()){
//                if (movie.getTitle().equals(titleSearch)){
//                    results.add(movie);
//                    break;
//                };
//            }
//        return results;
    }

    @Override
    public List<MovieEntity> findMoviesWithRatingGreaterThan(float rating) {
        return movieRepository.findMoviesWithRatingGreaterThan(rating);
    }

    @Override
    public void deleteMovieById(ObjectId id) {
    movieRepository.deleteById(id.toString());
    }
}
