package cz.asenk.vsb.langis.jpa.domain;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 64)
    @NotNull
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "langugage", nullable = false)
    private LanguageLocale langugage;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_level", nullable = false)
    private LanguageLevel languageLevel;

    @NotNull
    @Column(name = "prepaid_hours", nullable = false)
    private Integer prepaidHours;

    @NotNull
    @Column(name = "hour_pay", nullable = false)
    private Float hourPay;

    @NotNull
    @Column(name = "date_started", nullable = false)
    private LocalDate dateStarted;

    @NotNull
    @Column(name = "date_ending", nullable = false)
    private LocalDate dateEnding;
}