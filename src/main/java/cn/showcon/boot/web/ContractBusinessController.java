package cn.showcon.boot.web;

import cn.showcon.boot.config.DbProperties;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 合同信息表 审批前端控制器
 * </p>
 *
 * @author hhh
 * @since 2022-05-04
 */
@RestController
public class ContractBusinessController {


    @Autowired
    private DbProperties dbProperties;

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    @Qualifier("systemProperties")
    private Map<String, Object> systemProperties;
    @Autowired
    @Qualifier("environment")
    private Environment environment;
    @Autowired
    @Qualifier("systemEnvironment")
    private Map<String, Object> systemEnvironment;

    @GetMapping("/get")
    public String getContractSnapshot() {

        return dbProperties.getName();
    }

}
