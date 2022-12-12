package cz.asenk.vsb.langis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.asenk.vsb.langis.jpa.domain.UserLanguge;
import cz.asenk.vsb.langis.jpa.domain.UserLangugeId;

public interface UserLangugeRepository extends JpaRepository<UserLanguge, UserLangugeId> {
}