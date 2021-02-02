package com.web.university.guide.controller;

import com.web.university.guide.dto.*;
import com.web.university.guide.model.*;
import com.web.university.guide.service.GuideService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GuideRestController {

    private static Logger LOG = LoggerFactory.getLogger(GuideRestController.class);

    private final GuideService guideService;

    public GuideRestController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping("/city/{city}/weather")
    public ResponseEntity<BaseResponse<WeatherContainer>> getWeatherForCity(@PathVariable("city") String city) throws Exception {
        LOG.debug("ricevuta richiesta per /city/{city}/weather");
        BaseResponse<WeatherContainer> weatherBaseResponse = new BaseResponse<>();
        WeatherContainer weatherForCity = guideService.getWeatherForCity(city);
        weatherBaseResponse.setBody(weatherForCity);
        return ResponseEntity.ok(weatherBaseResponse);

    }

    @GetMapping("/museums")
    public ResponseEntity<BaseResponse<List<MuseumDto>>> getMuseums() {

        List<MuseumDto> museumForIsernia = guideService.getMuseumsForIsernia();
        BaseResponse<List<MuseumDto>> listBaseResponse = new BaseResponse<>();
        listBaseResponse.setBody(museumForIsernia);

        return ResponseEntity.ok().body(listBaseResponse);

    }

    @GetMapping("/restaurants")
    public ResponseEntity<BaseResponse<List<RestaurantDto>>> getRestaurants() {
        List<RestaurantDto> restaurantList = guideService.getRestaurantForIsernia();
        BaseResponse<List<RestaurantDto>> listBaseResponse = new BaseResponse<>();
        listBaseResponse.setBody(restaurantList);

        return ResponseEntity.ok().body(listBaseResponse);
    }


    @PostMapping("/restaurants")
    public ResponseEntity addNewRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto returnLocale = guideService.addRestaurants(restaurantDto);
        return ResponseEntity.of(Optional.of(returnLocale));
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<BaseResponse<RestaurantDto>> getLocale(@PathVariable("id") Long id) {
        RestaurantDto restaurantDto = guideService.getRestaurant(id);
        BaseResponse<RestaurantDto> localeBaseResponse = new BaseResponse<RestaurantDto>().setBody(restaurantDto);
        return ResponseEntity.ok().body(localeBaseResponse);
    }

    @GetMapping("/places")
    public ResponseEntity<BaseResponse<List<PlaceDto>>> getPlaces(@RequestParam(value = "km", required = false) Long km) {
        List<PlaceDto> allPlacesLessThan;
        if (km != null) {
            allPlacesLessThan = guideService.findAllPlacesLessThan(km);
        } else allPlacesLessThan = guideService.finaAllPlaces();
        BaseResponse<List<PlaceDto>> placeDtoBaseResponse = new BaseResponse<>();
        placeDtoBaseResponse.setBody(allPlacesLessThan);
        return ResponseEntity.ok().body(placeDtoBaseResponse);
    }


    @ApiOperation(value = "Add review to a restaurant ", response = Iterable.class, tags = "addReview")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping("/restaurants/{id}/review")
    public ResponseEntity<BaseResponse<ReviewDto>> addReviw(@PathVariable(value = "id") Long id, @RequestBody ReviewDto reviewDto){
        ReviewDto reviewResponse = guideService.addReviwToRestaurant(id, reviewDto);
        BaseResponse<ReviewDto> baseResponse = new BaseResponse<>();
        baseResponse.setBody(reviewResponse);
        return ResponseEntity.ok().body(baseResponse);
    }

}

