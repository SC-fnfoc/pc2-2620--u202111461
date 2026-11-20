package com.aquamonitor.platform.u202111461.monitoring.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable 
public record PlanCode(@Column(name = "plan_code", nullable = false, unique = true)String Code) {
 public PlanCode {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("validation.planCode.required");
        }
    }
}