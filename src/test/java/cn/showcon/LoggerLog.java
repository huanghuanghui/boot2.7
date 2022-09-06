package cn.showcon;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java自带的logger
 */
public class LoggerLog {
    public static void main(String[] args) {
        //create logger
        Logger logger = Logger.getLogger("LoggerLog");
        logger.setLevel(Level.ALL);
        //create console handler
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.OFF);
        //add console handler to logger
        logger.addHandler(handler);
        try {
            //add fileHandler
            FileHandler fileHandler = new FileHandler("/Users/hhh/workspace/code/study/boot2.7/java-log/java-log.log");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new MyFormat());
            //add fileHandler to logger
            logger.addHandler(fileHandler);
        } catch (SecurityException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.info("Start");
        logger.info("Running");
        logger.info("End");    
    
    }    

}