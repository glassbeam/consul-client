package com.orbitz.consul.model.health;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableServiceIdHealth.class)
@JsonDeserialize(as = ImmutableServiceIdHealth.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ServiceIdHealth {

    @JsonProperty("AggregatedStatus")
    public abstract String getStatus();

    @JsonProperty("Service")
    public abstract Service getService();

    @JsonProperty("Checks")
    @JsonDeserialize(as = ImmutableList.class, contentAs = HealthCheck.class)
    public abstract List<HealthCheck> getChecks();

}