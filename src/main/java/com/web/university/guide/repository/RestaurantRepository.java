package com.web.university.guide.repository;

import com.web.university.guide.model.Restaurant;
import com.web.university.guide.model.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByRestaurantType(RestaurantType restaurantType);


}
