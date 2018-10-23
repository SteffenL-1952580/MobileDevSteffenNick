package com.example.a11601743.firstproject;



public class Movie  {
    public int id;
    public String title;
    public int year;
    public int rating;
    public String genre;
    public String description;

    public Movie(){

    }

    public Movie(String title, int year, int rating, String beschrijving){
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.description = beschrijving;
    }

    public Movie(String title, int rating, int year){
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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
