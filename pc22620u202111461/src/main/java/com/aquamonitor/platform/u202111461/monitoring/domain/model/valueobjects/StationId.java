package com.aquamonitor.platform.u202111461.monitoring.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable 

public record StationId(@Column(name = "station_id", nullable = false) UUID value) {
    public StationId {
        if (value == null) {
            throw new IllegalArgumentException("validation.stationId.required");
        }
    }
}