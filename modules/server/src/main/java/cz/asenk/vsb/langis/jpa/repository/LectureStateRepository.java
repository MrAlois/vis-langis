package cz.asenk.vsb.langis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.asenk.vsb.langis.jpa.domain.LectureState;

public interface LectureStateRepository extends JpaRepository<LectureState, String> {
}