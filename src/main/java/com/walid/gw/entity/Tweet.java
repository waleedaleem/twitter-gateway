package com.walid.gw.entity;

import java.util.Date;

import twitter4j.Status;

/**
 * @author wmoustafa
 */
public class Tweet {

    private static final int MAX_NAME_LENGTH = 30;

    private String text;
    private String userName;
    private String userImageUrl;
    private String country;
    private Date createdAt;
    private double latitude;
    private double longitude;
    private int retweetCount;

    public Tweet(Status tweet) {
        this.text = tweet.getText();
        this.userName = tweet.getUser().getName().toUpperCase();
        if (this.userName.length() > MAX_NAME_LENGTH) {
            this.userName = this.userName.substring(0, MAX_NAME_LENGTH);
        }
        this.userImageUrl = tweet.getUser().getProfileImageURL();
        this.createdAt = tweet.getCreatedAt();
        if (tweet.getPlace() != null) {
            this.country = tweet.getPlace().getCountry();
        }
        if (tweet.getGeoLocation() != null) {
            this.latitude = tweet.getGeoLocation().getLatitude();
            this.longitude = tweet.getGeoLocation().getLongitude();
        }
        this.retweetCount = tweet.getRetweetCount();
    }

    public String getText() {
        return text;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public String getCountry() {
        return country;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getRetweetCount() {
        return retweetCount;
    }
}
