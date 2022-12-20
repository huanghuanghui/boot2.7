package cn.showcon.boot.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@AutoConfigureAfter(ConfigurationB.class)
public class ConfigurationA {

    ConfigurationA(){
        System.out.println("CofigurationA  已经被初始化！");
    }
}





