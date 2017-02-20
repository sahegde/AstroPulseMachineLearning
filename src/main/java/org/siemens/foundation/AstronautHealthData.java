
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
    "spaceShipSensorData"
})
public class AstronautHealthData {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("spaceShipSensorData")
    private SpaceShipSensorData spaceShipSensorData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("spaceShipSensorData")
    public SpaceShipSensorData getSpaceShipSensorData() {
        return spaceShipSensorData;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("spaceShipSensorData")
    public void setSpaceShipSensorData(SpaceShipSensorData spaceShipSensorData) {
        this.spaceShipSensorData = spaceShipSensorData;
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
        return new HashCodeBuilder().append(spaceShipSensorData).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AstronautHealthData) == false) {
            return false;
        }
        AstronautHealthData rhs = ((AstronautHealthData) other);
        return new EqualsBuilder().append(spaceShipSensorData, rhs.spaceShipSensorData).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
