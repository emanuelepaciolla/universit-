package com.web.university.guide.repository;

import com.web.university.guide.model.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleRepository extends JpaRepository<Locale, Long> {
}
