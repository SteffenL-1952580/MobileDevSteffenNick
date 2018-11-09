package com.example.a11601743.firstproject;


public class Movie  {
    public int id;
    public String title;
    public String year;
    public Double rating;
    public String genre;
    public String description;

    public Movie(){

    }

    public Movie(String title, String year, Double rating, String beschrijving){
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.description = beschrijving;
    }

    public Movie(String title, Double rating, String year){
        this.title = title;
        this.rating = rating;
        this.year = year;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
