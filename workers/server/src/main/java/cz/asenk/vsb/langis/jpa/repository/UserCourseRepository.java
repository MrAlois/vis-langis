package cz.asenk.vsb.langis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.asenk.vsb.langis.jpa.domain.UserCourse;
import cz.asenk.vsb.langis.jpa.domain.UserCourseId;

public interface UserCourseRepository extends JpaRepository<UserCourse, UserCourseId> {
}