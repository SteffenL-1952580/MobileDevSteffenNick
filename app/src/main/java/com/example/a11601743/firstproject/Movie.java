package com.example.a11601743.firstproject;

public class Movie {
    public String title;
    public int rating;

    public Movie(){

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

    public int year;




}
