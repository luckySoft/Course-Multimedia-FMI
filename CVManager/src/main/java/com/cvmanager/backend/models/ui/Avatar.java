
package com.cvmanager.backend.models.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "main",
    "img"
})
public class Avatar {

    @JsonProperty("main")
    private Boolean main;
    @JsonProperty("img")
    private String img;

    @JsonProperty("main")
    public Boolean getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Boolean main) {
        this.main = main;
    }

    @JsonProperty("img")
    public String getImg() {
        return img;
    }

    @JsonProperty("img")
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("main", main).append("img", img).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(img).append(main).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Avatar) == false) {
            return false;
        }
        Avatar rhs = ((Avatar) other);
        return new EqualsBuilder().append(img, rhs.img).append(main, rhs.main).isEquals();
    }

}
