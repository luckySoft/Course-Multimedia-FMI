
package com.cvmanager.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column()
    private String name;
    @Column()
    private String lastName;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<AvatarEntity> mainProfiles = null;
    @Column()
    private String description;
    @Column()
    private String jobTitle;
    @Column()
    private String location;
    @Column()
    private String email;
    @Column()
    private String videoId;
    @Column()
    private String password;    
    @Column()
    private String facebook;
    @Column()
    private String twitter;
    @Column()
    private String linkedIn;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<FavTechnologyEntity> favTechnologies = null;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<LanguageEntity> languageEntities = null;

    @OneToMany(mappedBy = "user")
    private List<ExperienceEntity> experienceEntity = null;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<EducationEntity> educationEntity = null;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SocialSkillEntity> socialSkillEntities = null;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SkillEntity> skillEntities = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<AvatarEntity> getMainProfiles() {
        return mainProfiles;
    }

    public void setMainProfiles(List<AvatarEntity> mainProfiles) {
        this.mainProfiles = mainProfiles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public List<FavTechnologyEntity> getFavTechnologies() {
        return favTechnologies;
    }

    public void setFavTechnologies(List<FavTechnologyEntity> favTechnologies) {
        this.favTechnologies = favTechnologies;
    }

    public List<LanguageEntity> getLanguageEntities() {
        return languageEntities;
    }

    public void setLanguageEntities(List<LanguageEntity> languageEntities) {
        this.languageEntities = languageEntities;
    }

    public List<ExperienceEntity> getExperienceEntity() {
        return experienceEntity;
    }

    public void setExperienceEntity(List<ExperienceEntity> experienceEntity) {
        this.experienceEntity = experienceEntity;
    }

    public List<EducationEntity> getEducationEntity() {
        return educationEntity;
    }

    public void setEducationEntity(List<EducationEntity> educationEntity) {
        this.educationEntity = educationEntity;
    }

    public List<SocialSkillEntity> getSocialSkillEntities() {
        return socialSkillEntities;
    }

    public void setSocialSkillEntities(List<SocialSkillEntity> socialSkillEntities) {
        this.socialSkillEntities = socialSkillEntities;
    }


    public List<SkillEntity> getSkillEntities() {
        return skillEntities;
    }

    public void setSkillEntities(List<SkillEntity> skillEntities) {
        this.skillEntities = skillEntities;
    }
}
