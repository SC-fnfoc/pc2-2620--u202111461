package com.aquamonitor.platform.u202111461.monitoring.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.aquamonitor.platform.u202111461.monitoring.domain.model.commands.CreateSamplingPlanCommand;
import com.aquamonitor.platform.u202111461.monitoring.domain.model.valueobjects.*;
import com.aquamonitor.platform.u202111461.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@NoArgsConstructor 
@Entity 
@Table (Name = "sampling_plans")

public class SamplingPlan extends AuditableAbstractAggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PlanCode planCode;

    @Embedded
    private StationId stationId;

    @Embedded
    private SamplingWindow samplingWindow;

    @Embedded
    private SampleVolume sampleVolume;

    @Column(name = "priority_level", nullable = false)
    private Integer priorityLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SamplingPlanStatus status;

    @Column(name = "sampling_notes")
    private String samplingNotes;

    }
}