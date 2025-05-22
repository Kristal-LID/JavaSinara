package com.urfu.homework.foxwatch;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class FoxMetrics implements MeterBinder {
    private final Map<String, AtomicInteger> foxObservations = new ConcurrentHashMap<>();

    public FoxMetrics() {
        foxObservations.put("red_fox", new AtomicInteger(0));
        foxObservations.put("arctic_fox", new AtomicInteger(0));
        foxObservations.put("fennec_fox", new AtomicInteger(0));
    }

    public void observeFox(String foxType) {
        foxObservations.getOrDefault(foxType, new AtomicInteger(0)).incrementAndGet();
    }

    @Override
    public void bindTo(MeterRegistry registry) {
        foxObservations.forEach((foxType, counter) ->
                Gauge.builder("fox.observations", counter, AtomicInteger::get)
                        .tag("type", foxType)
                        .description("Number of observed foxes by type")
                        .register(registry)
        );
    }
}