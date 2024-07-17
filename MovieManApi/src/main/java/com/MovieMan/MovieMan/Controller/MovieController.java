package com.MovieMan.MovieMan.Controller;

import com.MovieMan.MovieMan.DTO.MovieDTO;
import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Service.MovieService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping()
    public MovieDTO pushMovie(@RequestBody MovieEntity movie){
        return movieService.saveOrUpdateMovie(movie).toDTO();
    }



    @PutMapping(value="/{id}")
    public ResponseEntity<MovieEntity> updateMovie(@PathVariable("id") String id,@RequestBody MovieEntity movie){

        return ResponseEntity.ok(movieService.saveOrUpdateMovie(movie));
    }
    //GET
    @GetMapping()
    public ResponseEntity<List<MovieEntity>>getAll(){
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping(value="/{id}")
    public MovieEntity getMovieById(@PathVariable("id") ObjectId id){
        logger.info("getMovieById: movie found ~ MovieEntity Details ["+movieService.findById(id).get().toString()+"]");
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
