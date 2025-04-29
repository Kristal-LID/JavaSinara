package com.urfu.homework.listener;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EventController {
    private final EventsService eventService;

    @PostMapping("/regular")
    public void regularEvent() {
        eventService.publishRegularEvent();
    }

    @PostMapping("/async")
    public void asyncEvent() {
        eventService.publishAsyncEvent();
    }

    @PostMapping("/trans")
    public void transEvent() {
        eventService.publishTransactionalEvent();
    }
}