package cz.asenk.vsb.langis.jpa.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.Hibernate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class UserCourseId implements Serializable {
    @Serial
    private static final long serialVersionUID = -2204344327324828411L;

    @Size(max = 32)
    @NotNull
    @Column(name = "user_id", nullable = false, length = 32)
    private String userId;

    @NotNull
    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserCourseId entity = (UserCourseId) o;
        return Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.courseId, entity.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, courseId);
    }
}