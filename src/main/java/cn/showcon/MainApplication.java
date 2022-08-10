package cn.showcon;

import cn.showcon.contract.ContractCenterApplication;
import cn.showcon.draft.DraftApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 * @link 多application context <a herf="https://dev.to/__nikolamicic21/multiple-hierarchical-contexts-in-spring-boot-25nf"/>
 */

public class MainApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder().parent(MainApplication.class).web(WebApplicationType.NONE)
                .child(DraftApplication.class).web(WebApplicationType.SERVLET)
                .sibling(ContractCenterApplication.class).web(WebApplicationType.SERVLET)
                .run(args);
    }
}
