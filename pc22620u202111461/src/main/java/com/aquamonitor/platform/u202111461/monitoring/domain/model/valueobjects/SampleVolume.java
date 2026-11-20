package com.aquamonitor.platform.u202111461.monitoring.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

@Embeddable 

public record SampleVolume(
        @Column(name = "sample_volume_quantity", nullable = false) Integer quantity,
        @Column(name = "sample_volume_unit", nullable = false) String unit
) {
    public SampleVolume {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("validation.sampleVolume.quantity.positive");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("validation.sampleVolume.unit.required");
        }
    }

    public SampleVolume addVolume(Integer additionalVolume) {
        if (additionalVolume == null || additionalVolume <= 0) {
            throw new IllegalArgumentException("validation.sampleVolume.additional.positive");
        }
        long total = (long) this.quantity + additionalVolume;
        if (total > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("validation.sampleVolume.overflow");
        }
        return new SampleVolume((int) total, this.unit);
    }
}