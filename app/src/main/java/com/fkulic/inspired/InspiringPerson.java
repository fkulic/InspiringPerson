package com.fkulic.inspired;

/**
 * Created by Filip on 16.3.2017..
 */

public class InspiringPerson {
    private String name;
    private String lifespan;
    private int imgLoc;
    private String shortBio;
    private String qoute;

    public InspiringPerson(String name, String lifespan, int imgLoc, String shortBio, String qoute) {
        this.name = name;
        this.lifespan = lifespan;
        this.imgLoc = imgLoc;
        this.shortBio = shortBio;
        this.qoute = qoute;
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

    public String getQoute() {
        return qoute;
    }
}
