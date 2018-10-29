package com.stackroute.moviecruiserapp.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    private int id;
    @NotNull
    //private String title,language;
    @Size(min=2, message="Comments should have atleast 2 characters")
    private String comments;
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    //private LocalDateTime releaseDate;
    private String poster_path;
    private Boolean adult;
    private String overview;
    private String release_date;
    private Integer genre_ids[];
    private String original_title;
    private String original_language;
    private String backdrop_path;
    private Integer popularity;
    private Integer vote_count;
    private Boolean video;
    private Integer vote_average;

//    public Movie() {
//        releaseDate=LocalDateTime.now();
//    }
//
    public Movie(int id, String title, String language, String comments) {
        this.id = id;
        this.original_title= title;
        this.original_language = language;
        this.comments = comments;
        this.release_date="";
    }
    public void setTitle(String comments) {
        this.original_title = comments;
    }
    public String getTitle() {
        return this.original_title;
    }
    public void setLanguage(String comments) {
        this.original_language = comments;
    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//    public LocalDateTime getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(LocalDateTime releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//    @Override
//    public String toString(){
//        return id+title+comments+language+releaseDate;
//    }
}
