package cz.asenk.vsb.langis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.asenk.vsb.langis.jpa.model.LanguageLevel;

public interface LanguageLevelRepository extends JpaRepository<LanguageLevel, String> {
}