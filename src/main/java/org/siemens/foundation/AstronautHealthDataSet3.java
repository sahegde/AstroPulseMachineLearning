
package org.siemens.foundation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "sensor_values",
    "time_interval"
})
public class AstronautHealthDataSet3 {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sensor_values")
    private List<Object> sensorValues = new ArrayList<Object>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("time_interval")
    private TimeInterval__ timeInterval;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sensor_values")
    public List<Object> getSensorValues() {
        return sensorValues;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sensor_values")
    public void setSensorValues(List<Object> sensorValues) {
        this.sensorValues = sensorValues;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("time_interval")
    public TimeInterval__ getTimeInterval() {
        return timeInterval;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("time_interval")
    public void setTimeInterval(TimeInterval__ timeInterval) {
        this.timeInterval = timeInterval;
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
        return new HashCodeBuilder().append(sensorValues).append(timeInterval).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AstronautHealthDataSet3) == false) {
            return false;
        }
        AstronautHealthDataSet3 rhs = ((AstronautHealthDataSet3) other);
        return new EqualsBuilder().append(sensorValues, rhs.sensorValues).append(timeInterval, rhs.timeInterval).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
