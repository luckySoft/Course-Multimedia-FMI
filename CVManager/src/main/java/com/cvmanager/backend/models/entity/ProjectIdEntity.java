package com.cvmanager.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "projectIds")
public class ProjectIdEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column()
    private String projectId;
    @ManyToOne()
    @JoinColumn(name = "experience_id", nullable = false)
    private ExperienceEntity experience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public ExperienceEntity getExperience() {
        return experience;
    }

    public void setExperience(ExperienceEntity experience) {
        this.experience = experience;
    }
}
