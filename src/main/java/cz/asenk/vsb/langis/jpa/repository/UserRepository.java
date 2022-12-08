package cz.asenk.vsb.langis.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cz.asenk.vsb.langis.jpa.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where lower(u.name) like lower(concat('%', :searchTerm, '%'))")
    List<User> search(@Param("searchTerm") String searchTerm);
}