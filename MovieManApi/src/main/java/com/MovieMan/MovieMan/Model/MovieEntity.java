package com.MovieMan.MovieMan.Model;

import com.MovieMan.MovieMan.DTO.MovieDTO;
import com.MovieMan.MovieMan.Tools.PrettyPrintingMap;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Document("movies")
public class MovieEntity {
    @Id
    @Generated
    private ObjectId id;

    private Float rating;

    private String title;
    private String description;
    private Map<String,String> castAndRole;
    private Set<String> genre;

    @DBRef
    @JsonManagedReference
    private List<ObjectId> reviews ;


    //Map<String, String> castAndRole, Set<String> genre

    public MovieEntity(ObjectId id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
//        this.castAndRole = castAndRole;
//        this.genre = genre;
    }
    public MovieDTO toDTO(){
        return new MovieDTO(id,title,description);
    }
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
    public MovieEntity addReview(ObjectId review){
        this.reviews.add(review);
        return this;
    }
    @Override
    public String toString(){
        return String.format("( [ID: %s ] - [title: %s] - [genre: %s] - [description: %s] - [cast-role: %s] )",
                getId(), getTitle(), genreToString(), getDescription(), new PrettyPrintingMap<String,String>(castAndRole));
        }

}
