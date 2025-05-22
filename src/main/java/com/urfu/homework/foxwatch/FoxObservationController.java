package com.urfu.homework.foxwatch;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/foxes")
@RequiredArgsConstructor
public class FoxObservationController {
    private final MeterRegistry meterRegistry;
    private final FoxMetrics foxMetrics;

    @PostMapping("/observe/{foxType}")
    public String observeFox(@PathVariable String foxType) {
        Counter counter = meterRegistry.counter("fox.observations.count", "type", foxType);
        counter.increment();

        foxMetrics.observeFox(foxType);

        return "Зарегистрировано наблюдение лисицы: " + foxType;
    }

    @Timed(value = "fox.observation.time", description = "Time taken to process fox observation")
    @GetMapping("/recent")
    public String getRecentObservation() throws InterruptedException {
        Thread.sleep(200);
        return "Последнее наблюдение: рыжая лисица в 14:30";
    }
}