
package com.cvmanager.backend.models.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "level"
})
public class Language {

    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private String level;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("level", level).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(level).append(name).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Language) == false) {
            return false;
        }
        Language rhs = ((Language) other);
        return new EqualsBuilder().append(level, rhs.level).append(name, rhs.name).isEquals();
    }

}
