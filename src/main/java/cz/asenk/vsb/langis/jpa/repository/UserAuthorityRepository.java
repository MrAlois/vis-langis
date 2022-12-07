package cz.asenk.vsb.langis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.asenk.vsb.langis.jpa.model.UserAuthority;
import cz.asenk.vsb.langis.jpa.model.UserAuthorityId;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, UserAuthorityId> {
}