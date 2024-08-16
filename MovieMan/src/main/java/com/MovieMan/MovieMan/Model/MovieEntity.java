
package com.MovieMan.MovieMan.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Document("movies")
public class MovieEntity {
    @Id
    @Generated
    private String id;

    private Float rating;

    private String title;
    private String description;
    private Map<String,String> castAndRole;
    private Set<String> genre;
    private List<ReviewEntity> reviews ;

    private String releaseDate;

    //Map<String, String> castAndRole, Set<String> genre

    public MovieEntity(String id, Float rating, String title, String description, Map<String, String> castAndRole, Set<String> genre, List<ReviewEntity> reviews,String releaseDate) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.description = description;
        this.castAndRole = castAndRole;
        this.genre = genre;
        this.reviews = reviews;
        this.releaseDate = releaseDate;
    }

//    public MovieEntity toDTO(){
//        return new MovMovieDTOieDTO(id,title,description);
//    }
    public String genreToString(){
        String result = "";
        for(String genre:genre){
            result += ","+genre;
        }
        return result;
    }
    public String castAndRoleToString(){
        String result ="";

        return result;
    }
    @Override
    public String toString(){
        return String.format("( [ID: %s ] - [title: %s] - [genre: %s] - [description: %s]s )",
                getId(), getTitle(), genreToString(), getDescription());
        }
}
