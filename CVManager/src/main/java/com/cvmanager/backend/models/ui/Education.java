
package com.cvmanager.backend.models.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "period",
    "specialty",
    "institution",
    "address",
    "url"
})
public class Education {

    @JsonProperty("period")
    private Period period;
    @JsonProperty("specialty")
    private String specialty;
    @JsonProperty("institution")
    private String institution;
    @JsonProperty("address")
    private String address;
    @JsonProperty("url")
    private String url;

    @JsonProperty("period")
    public Period getPeriod() {
        return period;
    }

    @JsonProperty("period")
    public void setPeriod(Period period) {
        this.period = period;
    }

    @JsonProperty("specialty")
    public String getSpecialty() {
        return specialty;
    }

    @JsonProperty("specialty")
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @JsonProperty("institution")
    public String getInstitution() {
        return institution;
    }

    @JsonProperty("institution")
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("period", period).append("specialty", specialty).append("institution", institution).append("address", address).append("url", url).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(address).append(period).append(specialty).append(url).append(institution).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Education) == false) {
            return false;
        }
        Education rhs = ((Education) other);
        return new EqualsBuilder().append(address, rhs.address).append(period, rhs.period).append(specialty, rhs.specialty).append(url, rhs.url).append(institution, rhs.institution).isEquals();
    }

}
