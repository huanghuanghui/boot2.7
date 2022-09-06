package cn.showcon.boot.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class ContractModifyEventPublishEvent {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent( String contractCode ) {
        applicationEventPublisher.publishEvent(new ContractModifyEvent(this,contractCode));
    }
}
