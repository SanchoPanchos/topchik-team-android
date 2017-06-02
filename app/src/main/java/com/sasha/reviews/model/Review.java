package com.sasha.reviews.model;


public class Review {

    private String review;
    private int userID;

    public Review(String review, int userID) {
        this.review = review;
        this.userID = userID;
    }

    public String getReview() {
        return review;
    }

    public int getUserID() {
        return userID;
    }
}
