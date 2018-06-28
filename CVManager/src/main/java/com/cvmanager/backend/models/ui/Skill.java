
package com.cvmanager.backend.models.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "software",
    "percentage",
    "theme",
    "image"
})
public class Skill {

    @JsonProperty("software")
    private String software;
    @JsonProperty("percentage")
    private String percentage;
    @JsonProperty("theme")
    private String theme;
    @JsonProperty("image")
    private String image;

    @JsonProperty("software")
    public String getSoftware() {
        return software;
    }

    @JsonProperty("software")
    public void setSoftware(String software) {
        this.software = software;
    }

    @JsonProperty("percentage")
    public String getPercentage() {
        return percentage;
    }

    @JsonProperty("percentage")
    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @JsonProperty("theme")
    public String getTheme() {
        return theme;
    }

    @JsonProperty("theme")
    public void setTheme(String theme) {
        this.theme = theme;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("software", software).append("percentage", percentage).append("theme", theme).append("image", image).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(software).append(percentage).append(theme).append(image).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Skill) == false) {
            return false;
        }
        Skill rhs = ((Skill) other);
        return new EqualsBuilder().append(software, rhs.software).append(percentage, rhs.percentage).append(theme, rhs.theme).append(image, rhs.image).isEquals();
    }

}
