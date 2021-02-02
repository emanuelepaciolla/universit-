package com.web.university.guide.model;

import javax.persistence.*;

@Entity
@Table(name = "ristoranti")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    private String name;

    private String address;

    private String descrizione;

    private String tipoCucina;

    private String numero;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private RestaurantType restaurantType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipoCucina() {
        return tipoCucina;
    }

    public void setTipoCucina(String tipoCucina) {
        this.tipoCucina = tipoCucina;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
