package com.MovieMan.MovieMan.Controller;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import com.MovieMan.MovieMan.Service.MovieService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("movies")
public class MovieController {
    public static Logger logger = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
    this.movieService = movieService;
    }

    //POST
    @PostMapping(value="")
    public ResponseEntity<MovieEntity> pushMovie(@RequestBody MovieEntity movie){
        movieService.saveOrUpdateMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);

    }



    @PutMapping(value="/{id}")
    public ResponseEntity<MovieEntity> updateMovie(@PathVariable("id") String id,@RequestBody MovieEntity movie){

        return ResponseEntity.ok().body(movieService.saveOrUpdateMovie(movie));
    }

    @PostMapping(value = "/testPost")
    public ResponseEntity<String> testPost(){
        return new ResponseEntity<>("completed",HttpStatus.CREATED);
    }
    @PostMapping(value ="/{id}/reviews")
    public ResponseEntity<ReviewEntity> addReview(@PathVariable("id") String id, @RequestBody ReviewEntity review){
        return ResponseEntity.ok().body(movieService.addReviewToMovie(id,review));
    }

    @GetMapping(value ="/{id}/reviews")
    public ResponseEntity<List<ReviewEntity>> findReviewsByMovieId(@PathVariable("id") String id){
        return ResponseEntity.ok().body(movieService.findReviewByMovieId(id));
    }
    //GET
    @GetMapping()
    public ResponseEntity<List<MovieEntity>>getAll(){
        ResponseEntity<List<MovieEntity>> movies = ResponseEntity.ok().body(movieService.findAll());
       // logger.debug(movies.toString());
        return movies;
    }

    @GetMapping(value="/{id}")
    public MovieEntity getMovieById(@PathVariable("id") String id){
       // logger.info("getMovieById: movie found ~ MovieEntity Details ["+movieService.findById(id).get().toString()+"]");
        return movieService.findById(id).get();
    }
//    @GetMapping(value="/{id}/reviews")
//    public List<ReviewEntity> getReviewsByID(@PathVariable("id") String id){
//        return movieService.findById(id).get().getReviews();
//    }

    @GetMapping(value ="/genre/{genre}")
    public List<MovieEntity> searchByGenre(@PathVariable("genre") String genre){
        return movieService.searchByGenre(genre);
    }
    @GetMapping(value ="/title/{title}")
    public List<MovieEntity> searchByTitle(@PathVariable("title") String title){
        for(MovieEntity movie:movieService.searchByTitle(title)){
           logger.info("searchByTitle() found ~"+movie.toString());
        }

        return movieService.searchByTitle(title);
    }

    @GetMapping(value = "/ratingGT/{rating}")
    public List<MovieEntity> getMoviesWithRatingGreaterThan(@PathVariable("rating") float rating){
        return movieService.findMoviesWithRatingGreaterThan(rating);
    }

    //DELETE
    @DeleteMapping(value="/{id}")
    public String deleteById(@PathVariable("id") String id){
        return deleteById(id)+ "deleted";
    }
    @DeleteMapping(value = "/deleteAll")
    public String deleteAll(){
        int counter=0;
        for(MovieEntity movie: movieService.findAll()){
            movieService.deleteMovieById(movie.getId());
            counter++;
        }
        return counter+" Movies Deleted";
    }
}
