package com.jerodis.event;

import com.jerodis.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VocEventListener {

    private final VocService vocService;

//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @EventListener
    @Async("vocExecutor")
    public void customerHandle(CustomerEvent event) {
        vocService.vocSave(event.getVocForm());
    }

//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @EventListener
    @Async("vocExecutor")
    public void carrierHandle(CarrierEvent event) {
        vocService.vocSave(event.getVocForm());
        // 이후 프로세스 진행 (귀책 불인정 시)
    }

}
