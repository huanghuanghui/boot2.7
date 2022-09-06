package cn.showcon.boot.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class ContractModifyEvent extends ApplicationEvent {

    /**
     * 合同编号
     */
    private String contractCode;



    public ContractModifyEvent(ContractModifyEventPublishEvent source ,String contractCode) {
        super(source);
        this.contractCode = contractCode;
    }
}
