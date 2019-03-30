package com.example.openwebinar.avengersinfo.recoverinfo.dto;

public class HeroInfo {

    private int id = 0;
    private String language = null;
    private int image = 0;
    private String hero = null;
    private String actor = null;
    private String description = null;
    private int[] colors = null;

    public HeroInfo(int id, String language, int image, String hero, String actor, String description, int[] colors) {
        this.id = id;
        this.language = language;
        this.image = image;
        this.hero = hero;
        this.actor = actor;
        this.description = description;
        this.colors = colors;
    }

    public int getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public int getImage() {
        return image;
    }

    public String getHero() {
        return hero;
    }

    public String getActor() {
        return actor;
    }

    public String getDescription() {
        return description;
    }

    public int[] getColors() {
        return colors;
    }
}
