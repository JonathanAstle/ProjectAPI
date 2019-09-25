package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int rating;
    private String comment;

    public Rating() {
        super();
    }

    public Rating(Long id, String name, int rating, String comment) {
        super();
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(Rating rating) {
        //this.id = rating.id;
        this.name = rating.name;
        this.rating = rating.rating;
        this.comment = rating.comment;
    }

}
