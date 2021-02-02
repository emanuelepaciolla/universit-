package com.web.university.guide.model;

import java.util.List;

public class WeatherContainer {

    private List<Weather> weather;

    private Long visibility;

    private Wind wind;

    private String name;

    public List<Weather> getWeather() {
        return weather;
    }

    public WeatherContainer setWeather(List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
