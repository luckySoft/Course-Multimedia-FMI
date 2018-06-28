
package com.cvmanager.backend.models.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "theme",
    "percentage"
})
public class SocialSkill {

    @JsonProperty("title")
    private String title;
    @JsonProperty("theme")
    private String theme;
    @JsonProperty("percentage")
    private Integer percentage;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("theme")
    public String getTheme() {
        return theme;
    }

    @JsonProperty("theme")
    public void setTheme(String theme) {
        this.theme = theme;
    }

    @JsonProperty("percentage")
    public Integer getPercentage() {
        return percentage;
    }

    @JsonProperty("percentage")
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("theme", theme).append("percentage", percentage).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(title).append(percentage).append(theme).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SocialSkill) == false) {
            return false;
        }
        SocialSkill rhs = ((SocialSkill) other);
        return new EqualsBuilder().append(title, rhs.title).append(percentage, rhs.percentage).append(theme, rhs.theme).isEquals();
    }

}
