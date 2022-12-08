package cz.asenk.vsb.langis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.asenk.vsb.langis.jpa.domain.UserAuthority;
import cz.asenk.vsb.langis.jpa.domain.UserAuthorityId;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, UserAuthorityId> {
}