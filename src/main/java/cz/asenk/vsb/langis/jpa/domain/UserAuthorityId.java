package cz.asenk.vsb.langis.jpa.domain;

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

@Getter
@Setter

@Embeddable
public class UserAuthorityId implements Serializable {
    @Serial
    private static final long serialVersionUID = -6966816922314382442L;
    @Size(max = 32)
    @NotNull
    @Column(name = "user_id", nullable = false, length = 32)
    private String userId;

    @Size(max = 32)
    @NotNull
    @Column(name = "role", nullable = false, length = 32)
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserAuthorityId entity = (UserAuthorityId) o;
        return Objects.equals(this.role, entity.role) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, userId);
    }

}