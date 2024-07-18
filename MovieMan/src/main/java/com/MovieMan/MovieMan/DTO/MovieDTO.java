//package com.MovieMan.MovieMan.DTO;
//
//import com.MovieMan.MovieMan.Model.MovieEntity;
//import lombok.Generated;
//import lombok.Getter;
//import lombok.Setter;
//import org.bson.types.ObjectId;
//import org.springframework.data.annotation.Id;
//
//import java.util.Map;
//import java.util.Set;
//
//@Getter
//@Setter
//public class MovieDTO {
//
//    private String id;
//
//    private String title;
//    private String description;
//    private Map<String,String> castAndRole;
////    private Set<String> genre;
//
//    public MovieDTO(String id, String title, String description) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
////        this.castAndRole = castAndRole;
////        this.genre = genre;
//    }
//    public MovieEntity toEntity(){
//        return new MovieEntity(getId(),getTitle(),getDescription());
//    }
//    @Override
//    public String toString(){
//        return "title: "+getTitle()+" genre: "+" description: "+getDescription();
//    }
//}
