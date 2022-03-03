package com.web.university.guide.repository;

import com.web.university.guide.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findAllByDistanzaLessThan(Long distanza);

}
