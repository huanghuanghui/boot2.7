package cn.showcon.boot.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ContractModifyListener implements ApplicationListener<ContractModifyEvent> {

    @Override
    public void onApplicationEvent(ContractModifyEvent event) {
        String contractCode = event.getContractCode();
        log.info("合同修改监听-{}", contractCode);

    }
}
