package com.web.university.guide.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(value = "Review")
public class ReviewDto {


    @ApiModelProperty(required = true, example = "M_Rossi")
    private String user;

    @ApiModelProperty(required = true, example = "2019-11-11")
    private LocalDate date;

    @ApiModelProperty(required = true, example = "Si mangia bene")
    private String text;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
