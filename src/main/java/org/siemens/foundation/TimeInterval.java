
package org.siemens.foundation;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "start_date_time",
    "end_date_time"
})
public class TimeInterval {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("start_date_time")
    private String startDateTime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("end_date_time")
    private String endDateTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("start_date_time")
    public String getStartDateTime() {
        return startDateTime;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("start_date_time")
    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("end_date_time")
    public String getEndDateTime() {
        return endDateTime;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("end_date_time")
    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(startDateTime).append(endDateTime).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TimeInterval) == false) {
            return false;
        }
        TimeInterval rhs = ((TimeInterval) other);
        return new EqualsBuilder().append(startDateTime, rhs.startDateTime).append(endDateTime, rhs.endDateTime).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
