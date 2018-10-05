package com.stackroute.moviecruiserapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Movie {
    @Id
    private int id;
    private String title,language,comments;
    private LocalDateTime releaseDate;

    public Movie() {
        releaseDate=LocalDateTime.now();
    }

    public Movie(int id, String title, String language, String comments) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.comments = comments;
        this.releaseDate=LocalDateTime.now();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }
    @Override
    public String toString(){
        return id+title+comments+language+releaseDate;
    }
}
