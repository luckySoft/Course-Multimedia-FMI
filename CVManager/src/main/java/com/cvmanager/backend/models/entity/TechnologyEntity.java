package com.cvmanager.backend.models.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "technologies")
public class TechnologyEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column()
    private String technology;
    @ManyToOne()
    @JoinColumn(name = "experience_id", nullable = false)
    private ExperienceEntity experience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public ExperienceEntity getExperience() {
        return experience;
    }

    public void setExperience(ExperienceEntity experience) {
        this.experience = experience;
    }
}