package com.web.university.guide.dto;

public class PlaceDto {

    private String address;
    private String name;
    private String descrizione;
    private String type ;
    private Long distanza;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDistanza() {
        return distanza;
    }

    public void setDistanza(Long distanza) {
        this.distanza = distanza;
    }
}
