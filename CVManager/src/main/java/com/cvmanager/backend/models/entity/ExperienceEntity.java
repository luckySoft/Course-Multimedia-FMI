
package com.cvmanager.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "experience")
public class ExperienceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column()
    private String fromDate;
    @Column()
    private String toDate;
    @Column()
    private String job;
    @Column()
    private String company;
    @Column()
    private String address;
    @Column()
    private String expUrl;
    @Column()
    private String type;

    @OneToMany(mappedBy = "experience")
    private List<ResponsibilityEntity> responsibilities = null;

    @OneToMany(mappedBy = "experience")
    private List<TechnologyEntity> technologies = null;

    @OneToMany(mappedBy = "experience")
    private List<ProjectIdEntity> projectIds = null;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private UserEntity user;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExpUrl() {
        return expUrl;
    }

    public void setExpUrl(String expUrl) {
        this.expUrl = expUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ResponsibilityEntity> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<ResponsibilityEntity> responsibilities) {
        this.responsibilities = responsibilities;
    }

    public List<TechnologyEntity> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyEntity> technologies) {
        this.technologies = technologies;
    }

    public List<ProjectIdEntity> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<ProjectIdEntity> projectIds) {
        this.projectIds = projectIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
