
package com.cvmanager.backend.models.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "period",
    "job",
    "company",
    "address",
    "url",
    "type",
    "responsibilities",
    "technologies",
    "projectIds"
})
public class Experience {

    @JsonProperty("period")
    private Period period;
    @JsonProperty("job")
    private String job;
    @JsonProperty("company")
    private String company;
    @JsonProperty("address")
    private String address;
    @JsonProperty("url")
    private String url;
    @JsonProperty("type")
    private String type;
    @JsonProperty("responsibilities")
    private List<String> responsibilities = null;
    @JsonProperty("technologies")
    private List<String> technologies = null;
    @JsonProperty("projectIds")
    private List<String> projectIds = null;

    @JsonProperty("period")
    public Period getPeriod() {
        return period;
    }

    @JsonProperty("period")
    public void setPeriod(Period period) {
        this.period = period;
    }

    @JsonProperty("job")
    public String getJob() {
        return job;
    }

    @JsonProperty("job")
    public void setJob(String job) {
        this.job = job;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
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

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("responsibilities")
    public List<String> getResponsibilities() {
        return responsibilities;
    }

    @JsonProperty("responsibilities")
    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    @JsonProperty("technologies")
    public List<String> getTechnologies() {
        return technologies;
    }

    @JsonProperty("technologies")
    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    @JsonProperty("projectIds")
    public List<String> getProjectIds() {
        return projectIds;
    }

    @JsonProperty("projectIds")
    public void setProjectIds(List<String> projectIds) {
        this.projectIds = projectIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("period", period).append("job", job).append("company", company).append("address", address).append("url", url).append("type", type).append("responsibilities", responsibilities).append("technologies", technologies).append("projectIds", projectIds).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(technologies).append(projectIds).append(address).append(responsibilities).append(company).append(job).append(type).append(period).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Experience) == false) {
            return false;
        }
        Experience rhs = ((Experience) other);
        return new EqualsBuilder().append(technologies, rhs.technologies).append(projectIds, rhs.projectIds).append(address, rhs.address).append(responsibilities, rhs.responsibilities).append(company, rhs.company).append(job, rhs.job).append(type, rhs.type).append(period, rhs.period).append(url, rhs.url).isEquals();
    }

}
