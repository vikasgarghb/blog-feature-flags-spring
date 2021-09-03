package blog.vgarg.features.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getHello() {
        return "Hello!!";
    }

    public String getGoodMorning() {
        return "Good Morning!!";
    }

    public String getGoodEvening() {
        return "Good Evening!!";
    }
}
