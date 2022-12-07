package cz.asenk.vsb.langis.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "language_level")
public class LanguageLevel {
    @Id
    @Size(max = 32)
    @Column(name = "level", nullable = false, length = 32)
    private String id;

    @Size(max = 32)
    @Column(name = "desription", length = 32)
    private String desription;
}