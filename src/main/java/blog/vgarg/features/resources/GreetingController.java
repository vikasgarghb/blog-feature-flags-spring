package blog.vgarg.features.resources;

import blog.vgarg.features.annotations.CheckFeatureFlag;
import blog.vgarg.features.aspect.FeatureFlagAspect;
import blog.vgarg.features.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    private GreetingService greetingService;

    @Autowired
    private FeatureFlagAspect aspect;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>(greetingService.getHello(), HttpStatus.OK);
    }

    @CheckFeatureFlag(flag = "flags.goodmorning")
    @GetMapping("/good-morning")
    public ResponseEntity<String> getGoodMorning() {
        return new ResponseEntity<>(greetingService.getGoodMorning(), HttpStatus.OK);
    }

    @CheckFeatureFlag(flag = "flags.goodevening")
    @GetMapping("/good-evening")
    public ResponseEntity<String> getGoodEvening() {
        System.out.println(aspect);
        return new ResponseEntity<>(greetingService.getGoodEvening(), HttpStatus.OK);
    }
}
