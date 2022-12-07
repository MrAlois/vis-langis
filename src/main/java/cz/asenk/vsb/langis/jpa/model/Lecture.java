package cz.asenk.vsb.langis.jpa.model;

import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lecturer_id", nullable = false)
    private User lecturer;

    @Column(name = "started")
    private Instant started;

    @Column(name = "ended")
    private Instant ended;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "state", nullable = false)
    private LectureState state;

    @Column(name = "attended")
    private Integer attended;

    @Size(max = 128)
    @Column(name = "topic", length = 128)
    private String topic;

    @Size(max = 255)
    @Column(name = "description")
    private String description;
}