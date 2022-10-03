package cn.showcon.boot;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@RestController
public class GcTestController {
    private Queue objCache = new ConcurrentLinkedDeque<>();

    @RequestMapping("/test")
    public Greeting greeting() {
        Greeting greeting = new Greeting("Hello World!");
        if (objCache.size() >= 600000) {
            objCache.clear();
        } else {
            objCache.add(greeting);
        }
        return greeting;
    }
}

@Data
@AllArgsConstructor
class Greeting {
    private String message;
}