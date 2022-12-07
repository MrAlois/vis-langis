package cz.asenk.vsb.langis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.asenk.vsb.langis.jpa.model.UserCourse;
import cz.asenk.vsb.langis.jpa.model.UserCourseId;

public interface UserCourseRepository extends JpaRepository<UserCourse, UserCourseId> {
}