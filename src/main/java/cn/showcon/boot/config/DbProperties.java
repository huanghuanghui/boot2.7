package cn.showcon.boot.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "db")
@RefreshScope
@Getter
public class DbProperties {

    private String name;
    private String url;
}