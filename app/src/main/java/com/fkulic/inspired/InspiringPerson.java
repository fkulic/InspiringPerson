package com.fkulic.inspired;

/**
 * Created by Filip on 16.3.2017..
 */

public class InspiringPerson {
    private String name;
    private String lifespan;
    private int imgLoc;
    private String shortBio;
    private String quote;

    public InspiringPerson(String name, String lifespan, int imgLoc, String shortBio, String quote) {
        this.name = name;
        this.lifespan = lifespan;
        this.imgLoc = imgLoc;
        this.shortBio = shortBio;
        this.quote = quote;
    }

    public String getName() {
        return name;
    }

    public String getLifespan() {
        return lifespan;
    }

    public int getImgLoc() {
        return imgLoc;
    }

    public String getShortBio() {
        return shortBio;
    }

    public String getQuote() {
        return quote;
    }
}
