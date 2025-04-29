package com.urfu.homework.listener;



import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class EventsService {

    private final ApplicationEventPublisher eventPublisher;

    public void publishRegularEvent() {
        log.info("Публикация обычного события " + System.currentTimeMillis());
        eventPublisher.publishEvent(new RegularEvent("regular"));
    }

    public void publishAsyncEvent() {
        log.info("Публикация асинхронного события " + System.currentTimeMillis());
        eventPublisher.publishEvent(new AsyncEvent("async"));
    }

    @Transactional
    public void publishTransactionalEvent() {
        log.info("Публикация транзакции " + System.currentTimeMillis());
        eventPublisher.publishEvent(new TransEvent("transactional", true));
        eventPublisher.publishEvent(new TransEvent("transactional", false));
    }
}