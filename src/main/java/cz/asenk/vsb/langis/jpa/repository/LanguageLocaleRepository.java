package cz.asenk.vsb.langis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.asenk.vsb.langis.jpa.model.LanguageLocale;

public interface LanguageLocaleRepository extends JpaRepository<LanguageLocale, String> {
}