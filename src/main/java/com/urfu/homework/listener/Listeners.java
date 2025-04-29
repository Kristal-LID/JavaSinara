package com.urfu.homework.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class Listeners {

    @EventListener
    public void handleRegularEvent(RegularEvent regularDTO) {
        log.info("Читаю  " + regularDTO.message() + System.currentTimeMillis());
    }

    @Async
    @EventListener
    public void handleAsyncEvent(AsyncEvent asyncEvent) {
        log.info("Читаю асинхронное " + asyncEvent.message() + System.currentTimeMillis());
    }

    @TransactionalEventListener
    public void handleTransactionalEvent(TransEvent transEvent) {
        if (transEvent.success()) {
            log.info("Обрабатываю " + transEvent.message() + System.currentTimeMillis());

        } else {
            log.info("Не обрабтать " + transEvent.message() + System.currentTimeMillis());
        }
    }
}
