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
@Table(name = "authority")
public class Authority {
    @Id
    @Size(max = 32)
    @Column(name = "role", nullable = false, length = 32)
    private String id;

    @Size(max = 255)
    @Column(name = "permissions")
    private String permissions;

    @Size(max = 255)
    @Column(name = "description")
    private String description;
}