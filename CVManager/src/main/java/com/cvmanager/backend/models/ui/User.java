
package com.cvmanager.backend.models.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "lastName",
        "avatars",
        "description",
        "jobTitle",
        "location",
        "email",
        "videoId",
        "password",
        "facebook",
        "twitter",
        "linkedIn",
        "favTechnologies",
        "languages",
        "experience",
        "education",
        "socialSkills",
        "devSkills"
})
public class User {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("avatars")
    private List<Avatar> mainProfiles = null;
    @JsonProperty("description")
    private String description;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("location")
    private String location;
    @JsonProperty("email")
    private String email;
    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("password")
    private String password;
    @JsonProperty("facebook")
    private String facebook;
    @JsonProperty("twitter")
    private String twitter;
    @JsonProperty("linkedIn")
    private String linkedIn;
    @JsonProperty("favTechnologies")
    private List<String> favTechnologies = null;
    @JsonProperty("languages")
    private List<Language> languages = null;
    @JsonProperty("experience")
    private List<Experience> experience = null;
    @JsonProperty("education")
    private List<Education> education = null;
    @JsonProperty("socialSkills")
    private List<SocialSkill> socialSkills = null;
    @JsonProperty("skills")
    private List<Skill> devSkills = null;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("mainProfiles")
    public List<Avatar> getMainProfiles() {
        if (mainProfiles == null) {
            mainProfiles = new ArrayList<>();
        }
        return mainProfiles;
    }

    @JsonProperty("mainProfiles")
    public void setMainProfiles(List<Avatar> mainProfiles) {
        this.mainProfiles = mainProfiles;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("facebook")
    public String getFacebook() {
        return facebook;
    }

    @JsonProperty("facebook")
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @JsonProperty("twitter")
    public String getTwitter() {
        return twitter;
    }

    @JsonProperty("twitter")
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @JsonProperty("linkedIn")
    public String getLinkedIn() {
        return linkedIn;
    }

    @JsonProperty("linkedIn")
    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    @JsonProperty("favTechnologies")
    public List<String> getFavTechnologies() {
        if (favTechnologies == null) {
            favTechnologies = new ArrayList<>();
        }
        return favTechnologies;
    }

    @JsonProperty("favTechnologies")
    public void setFavTechnologies(List<String> favTechnologies) {
        this.favTechnologies = favTechnologies;
    }

    @JsonProperty("languages")
    public List<Language> getLanguages() {
        if (languages == null) {
            languages = new ArrayList<>();
        }
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @JsonProperty("experience")
    public List<Experience> getExperience() {
        if (experience == null) {
            experience = new ArrayList<>();
        }
        return experience;
    }

    @JsonProperty("experience")
    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    @JsonProperty("education")
    public List<Education> getEducation() {
        if (education == null) {
            education = new ArrayList<>();
        }
        return education;
    }

    @JsonProperty("education")
    public void setEducation(List<Education> education) {
        this.education = education;
    }

    @JsonProperty("socialSkills")
    public List<SocialSkill> getSocialSkills() {
        if (socialSkills == null) {
            socialSkills = new ArrayList<>();
        }
        return socialSkills;
    }

    @JsonProperty("socialSkills")
    public void setSocialSkills(List<SocialSkill> socialSkills) {
        this.socialSkills = socialSkills;
    }

    @JsonProperty("devSkills")
    public List<Skill> getDevSkills() {
        if (devSkills == null) {
            devSkills = new ArrayList<>();
        }
        return devSkills;
    }

    @JsonProperty("devSkills")
    public void setDevSkills(List<Skill> devSkills) {
        this.devSkills = devSkills;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("lastName", lastName).append("mainProfiles", mainProfiles).append("description", description).append("jobTitle", jobTitle).append("location", location).append("email", email).append("videoId", videoId).append("password", password).append("facebook", facebook).append("twitter", twitter).append("linkedIn", linkedIn).append("favTechnologies", favTechnologies).append("languages", languages).append("experience", experience).append("education", education).append("socialSkills", socialSkills).append("devSkills", devSkills).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastName).append(linkedIn).append(location).append(socialSkills).append(education).append(devSkills).append(password).append(favTechnologies).append(id).append(languages).append(twitter).append(mainProfiles).append(email).append(description).append(facebook).append(videoId).append(name).append(experience).append(jobTitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(lastName, rhs.lastName).append(linkedIn, rhs.linkedIn).append(location, rhs.location).append(socialSkills, rhs.socialSkills).append(education, rhs.education).append(devSkills, rhs.devSkills).append(password, rhs.password).append(favTechnologies, rhs.favTechnologies).append(id, rhs.id).append(languages, rhs.languages).append(twitter, rhs.twitter).append(mainProfiles, rhs.mainProfiles).append(email, rhs.email).append(description, rhs.description).append(facebook, rhs.facebook).append(videoId, rhs.videoId).append(name, rhs.name).append(experience, rhs.experience).append(jobTitle, rhs.jobTitle).isEquals();
    }

}
