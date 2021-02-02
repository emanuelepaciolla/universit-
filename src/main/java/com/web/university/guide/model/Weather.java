package com.web.university.guide.model;

import java.io.Serializable;

public class Weather implements Serializable {

    private String main;
    private String description;

    public String getMain() {
        return main;
    }

    public Weather setMain(String main) {
        this.main = main;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Weather setDescription(String description) {
        this.description = description;
        return this;
    }
}
