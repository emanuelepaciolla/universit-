package com.web.university.guide.repository;

import com.web.university.guide.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findAllByDistanzaLessThan(Long distanza);

}
