package cz.asenk.vsb.langis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.asenk.vsb.langis.jpa.domain.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}