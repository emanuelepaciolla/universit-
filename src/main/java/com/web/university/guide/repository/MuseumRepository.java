package com.web.university.guide.repository;

import com.web.university.guide.model.Museum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseumRepository extends JpaRepository<Museum, Long> {
}
