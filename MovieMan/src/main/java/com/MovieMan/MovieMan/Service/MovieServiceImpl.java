package com.MovieMan.MovieMan.Service;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import com.MovieMan.MovieMan.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MovieEntity> findAll() {
        return movieRepository.findAll();
    }

    @Transactional
    @Override
    public ReviewEntity addReviewToMovie(String movieId, ReviewEntity review) {
        movieRepository.addReviewToMovie(movieId,review);
        return review;
    }

    @Override
    public Optional<MovieEntity> findById(String id) {
        return movieRepository.findById(id);
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
//        return movieRepository.findMoviesByTitle(titleSearch);
        return movieRepository.findByTitleContainingIgnoreCase(titleSearch);
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
    public List<ReviewEntity> findReviewByMovieId(String movieId) {
        return movieRepository.findReviewsByMovieId(movieId);
    }

    @Override
    public void deleteMovieById(String id) {
    movieRepository.deleteById(id);
    }
}
