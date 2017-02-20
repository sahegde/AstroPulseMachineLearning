
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
    "AstronautHealthData_Set1",
    "AstronautHealthData_Set2",
    "AstronautHealthData_Set3"
})
public class SpaceShipSensorData {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AstronautHealthData_Set1")
    private AstronautHealthDataSet1 astronautHealthDataSet1;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AstronautHealthData_Set2")
    private AstronautHealthDataSet2 astronautHealthDataSet2;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AstronautHealthData_Set3")
    private AstronautHealthDataSet3 astronautHealthDataSet3;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AstronautHealthData_Set1")
    public AstronautHealthDataSet1 getAstronautHealthDataSet1() {
        return astronautHealthDataSet1;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AstronautHealthData_Set1")
    public void setAstronautHealthDataSet1(AstronautHealthDataSet1 astronautHealthDataSet1) {
        this.astronautHealthDataSet1 = astronautHealthDataSet1;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AstronautHealthData_Set2")
    public AstronautHealthDataSet2 getAstronautHealthDataSet2() {
        return astronautHealthDataSet2;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AstronautHealthData_Set2")
    public void setAstronautHealthDataSet2(AstronautHealthDataSet2 astronautHealthDataSet2) {
        this.astronautHealthDataSet2 = astronautHealthDataSet2;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AstronautHealthData_Set3")
    public AstronautHealthDataSet3 getAstronautHealthDataSet3() {
        return astronautHealthDataSet3;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AstronautHealthData_Set3")
    public void setAstronautHealthDataSet3(AstronautHealthDataSet3 astronautHealthDataSet3) {
        this.astronautHealthDataSet3 = astronautHealthDataSet3;
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
        return new HashCodeBuilder().append(astronautHealthDataSet1).append(astronautHealthDataSet2).append(astronautHealthDataSet3).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpaceShipSensorData) == false) {
            return false;
        }
        SpaceShipSensorData rhs = ((SpaceShipSensorData) other);
        return new EqualsBuilder().append(astronautHealthDataSet1, rhs.astronautHealthDataSet1).append(astronautHealthDataSet2, rhs.astronautHealthDataSet2).append(astronautHealthDataSet3, rhs.astronautHealthDataSet3).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
