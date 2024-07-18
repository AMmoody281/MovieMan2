package com.MovieMan.MovieMan.Model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
@Getter
@Setter
public class UserEntity {
    @Id
    @Generated
    private String id;

    private String username;

    @DBRef
    private List<ReviewEntity> reviews;
}
