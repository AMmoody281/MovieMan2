package com.MovieMan.MovieMan.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("reviews")
public class ReviewEntity {
    @Id
    @Generated
    private ObjectId id;

    private String title;

    private String review;

    private float rating;

    @DBRef
    @JsonBackReference
    private ObjectId movie;

//    @DBRef
//    private UserEntity user;
}
