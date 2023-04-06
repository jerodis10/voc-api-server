package com.jerodis.event;

import com.jerodis.dto.VocForm;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventVocService implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher eventPublisher;

    public void vocSaveEvent(VocForm vocForm) {
        if (vocForm.getParty().name().equals("CUSTOMER")) {
            eventPublisher.publishEvent(new CustomerEvent(vocForm));
        } else {
            eventPublisher.publishEvent(new CarrierEvent(vocForm));
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
