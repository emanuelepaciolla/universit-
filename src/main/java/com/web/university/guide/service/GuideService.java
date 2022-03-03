package com.web.university.guide.service;

import com.web.university.guide.dto.MuseumDto;
import com.web.university.guide.dto.PlaceDto;
import com.web.university.guide.dto.RestaurantDto;
import com.web.university.guide.dto.ReviewDto;
import com.web.university.guide.exception.NotFoundException;
import com.web.university.guide.helper.RestTemplateHelper;
import com.web.university.guide.model.*;
import com.web.university.guide.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class GuideService {

    private final String APP_ID = "APPID";
    private final String VALUE = "";

    @Autowired
    private MuseumRepository museumRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Autowired
    private RestTemplateHelper restTemplateHelper;


    public WeatherContainer getWeatherForCity(String city) throws Exception{
        HashMap<String, String> properties = new HashMap<>();
        properties.put("q", city);
        properties.put(APP_ID, VALUE);
        Optional<WeatherContainer> request = restTemplateHelper.getRequest(properties, WeatherContainer.class);
        if (request.isPresent())
            return request.get();
        else throw new RuntimeException();
    }

    public List<MuseumDto> getMuseumsForIsernia() {
        List<Museum> all = museumRepository.findAll();
        List<MuseumDto> museumDtos = convertMuseums(all);
        return museumDtos;
    }

    public List<RestaurantDto> getRestaurantForIsernia() {
        List<Restaurant> allRestaurants = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtos = convertService(allRestaurants);
        return restaurantDtos;
    }

    public RestaurantDto getRestaurantForIsernia(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isPresent()){
            Restaurant restaurant = optionalRestaurant.get();
            RestaurantDto restaurantDto = new RestaurantDto();
            BeanUtils.copyProperties(restaurant, restaurantDto);
            return restaurantDto;
        }else throw new NotFoundException("Ristorante con id " +  id + " non trovato");
    }

    public RestaurantDto addRestaurants(RestaurantDto restaurantDto) {
        Restaurant restaurant = convertRestaurant(restaurantDto);
        Restaurant save = restaurantRepository.save(restaurant);
        return restaurantDto;
    }

    public List<RestaurantDto> getRestaurantFromSpecificType(RestaurantType restaurantType){
        List<Restaurant> restaurants = restaurantRepository.findAllByRestaurantType(restaurantType);
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        restaurants.forEach(restaurant ->
        {
            RestaurantDto restaurantDto = new RestaurantDto();
            BeanUtils.copyProperties(restaurant, restaurantDto);
            restaurantDtos.add(restaurantDto);
        });
        return restaurantDtos;
    }

    public RestaurantDto getRestaurant(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isPresent()){
            Restaurant restaurant = optionalRestaurant.get();
            RestaurantDto restaurantDto = convertRestaurant(restaurant);
            return restaurantDto;
        }throw new NotFoundException("Ristorante Non trovato");
    }

    private List<RestaurantDto> convertService(List<Restaurant> restaurants){
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        restaurants.forEach(restaurant ->
        {
            RestaurantDto restaurantDto = new RestaurantDto();
            BeanUtils.copyProperties(restaurant, restaurantDto);
            restaurantDtos.add(restaurantDto);
        });
        return restaurantDtos;
    }

    private List<MuseumDto> convertMuseums(List<Museum> museums){
        List<MuseumDto> museumsDto = new ArrayList<>();
        museums.forEach(restaurant ->
        {
            MuseumDto museumDto = new MuseumDto();
            BeanUtils.copyProperties(restaurant, museumDto);
            museumsDto.add(museumDto);
        });
        return museumsDto;
    }


    private List<PlaceDto> convertPlace(List<Place> places){
        List<PlaceDto> placeDtos = new ArrayList<>();
        places.forEach(place ->
        {
            PlaceDto placeDto = new PlaceDto();
            BeanUtils.copyProperties(place, placeDto);
            placeDtos.add(placeDto);
        });
        return placeDtos;
    }

    private Restaurant convertRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantDto, restaurant);
        return restaurant;
    }
    private RestaurantDto convertRestaurant(Restaurant restaurant){
        RestaurantDto restaurantDto = new RestaurantDto();
        BeanUtils.copyProperties(restaurant, restaurantDto);
        return restaurantDto;
    }

    private Review convertReview(ReviewDto reviewDto){
        Review review = new Review();
        BeanUtils.copyProperties(reviewDto, review);
        return review;
    }

    private ReviewDto convertReview(Review review){
        ReviewDto reviewDto = new ReviewDto();
        BeanUtils.copyProperties(review, reviewDto);
        return reviewDto;
    }

    @Autowired
    private PlaceRepository placeRepository;

    public List<PlaceDto> findAllPlacesLessThan(Long km) {
        List<Place> allByDistanzaLessThan = placeRepository.findAllByDistanzaLessThan(km);
        List<PlaceDto> placeDtos = convertPlace(allByDistanzaLessThan);
        return placeDtos;
    }

    public List<PlaceDto> finaAllPlaces() {

        List<Place> all = placeRepository.findAll();
        List<PlaceDto> placeDtos = convertPlace(all);
        return placeDtos;


    }

    public ReviewDto addReviwToRestaurant(Long id, ReviewDto reviewDto) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isPresent()){
            Review save = reviewRepository.save(convertReview(reviewDto));
            return convertReview(save);
        }else throw new NotFoundException("No Restaurant find for ID " + id);
    }
}
