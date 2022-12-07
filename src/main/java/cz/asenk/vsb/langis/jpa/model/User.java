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
@Table(name = "user")
public class User {
    @Id
    @Size(max = 64)
    @Column(name = "user_id", nullable = false, length = 64)
    private String id;

    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;

    @Size(max = 64)
    @NotNull
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Size(max = 32)
    @Column(name = "telephone", length = 32)
    private String telephone;

    @Size(max = 64)
    @Column(name = "email", length = 64)
    private String email;
}