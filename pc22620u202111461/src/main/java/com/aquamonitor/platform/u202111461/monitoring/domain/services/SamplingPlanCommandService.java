package com.aquamonitor.platform.u202111461.monitoring.domain.services;

import com.aquamonitor.platform.u202111461.monitoring.domain.model.commands.CreateSamplingPlanCommand;
import com.aquamonitor.platform.u202111461.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202111461.shared.domain.model.results.Result;

public class SamplingPlanCommandService {
    Result<SamplingPlan> handle(CreateSamplingPlanCommand command);
}
