package cn.showcon.boot.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/9/1
 */
@RestController
@Log4j2
public class TestController {


    @GetMapping("/test")
    public String test() {
        Log log = LogFactory.getLog(TestController.class.getName());
        Logger logger = LoggerFactory.getLogger(TestController.class.getName());
        log.info("LogFactory xxxx");
        logger.info("LoggerFactory xxxxx");
        return "SUCCESS";
    }


    @GetMapping("/test2")
    public String test2() {
        final org.apache.logging.log4j.Logger log = LogManager.getLogger(TestController.class);
        log.info("xxxx");
        return "SUCCESS";
    }

    @RequestMapping(value = "log/{logLevel}")
    public String log(@PathVariable("logLevel") String logLevel) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger logger = loggerContext.getLogger("root");
        ((ch.qos.logback.classic.Logger) logger).setLevel(Level.valueOf(logLevel));
        return "success";
    }
}
