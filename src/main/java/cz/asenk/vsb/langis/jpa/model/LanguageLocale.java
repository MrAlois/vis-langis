package cz.asenk.vsb.langis.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "language_locale")
public class LanguageLocale {
    @Id
    @Size(max = 32)
    @Column(name = "name", nullable = false, length = 32)
    private String id;

    @Size(max = 16)
    @NotNull
    @Column(name = "locale", nullable = false, length = 16)
    private String locale;
}