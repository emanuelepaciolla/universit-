package com.web.university.guide.repository;

import com.web.university.guide.model.Restaurant;
import com.web.university.guide.model.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByRestaurantType(RestaurantType restaurantType);


}
