
package com.cvmanager.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "education")
public class EducationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PeriodEntity periodEntity;

    @Column()
    private String specialty;

    @Column()
    private String institution;

    @Column()
    private String address;

    @Column()
    private String url;

    @ManyToOne
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public PeriodEntity getPeriodEntity() {
        return periodEntity;
    }

    public void setPeriodEntity(PeriodEntity periodEntity) {
        this.periodEntity = periodEntity;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
