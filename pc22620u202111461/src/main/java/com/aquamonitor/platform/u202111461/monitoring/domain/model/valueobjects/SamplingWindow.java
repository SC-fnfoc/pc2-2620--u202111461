package com.aquamonitor.platform.u202111461.monitoring.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable 
public record SamplingWindow(
        @Column(name = "sampling_window_start_date", nullable = false) LocalDate startDate,
        @Column(name = "sampling_window_end_date", nullable = false) LocalDate endDate
) {
    public SamplingWindow {
        if (startDate == null) {
            throw new IllegalArgumentException("validation.samplingWindow.startDate.required");
        }
        if (endDate == null) {
            throw new IllegalArgumentException("validation.samplingWindow.endDate.required");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("validation.samplingWindow.endDate.afterStart");
        }
    }

    public boolean contains(LocalDate checkDate) {
        if (checkDate == null) {
            throw new IllegalArgumentException("validation.samplingWindow.checkDate.required");
        }
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
    }
}