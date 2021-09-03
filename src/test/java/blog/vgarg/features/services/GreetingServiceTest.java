package blog.vgarg.features.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingServiceTest {
    private GreetingService greetingService;

    @BeforeEach
    public void setup() {
        greetingService = new GreetingService();
    }

    @Test
    public void testHello() {
        assertThat(greetingService.getHello()).isEqualTo("Hello!!");
    }

    @Test
    public void testGoodMorning() {
        assertThat(greetingService.getGoodMorning()).isEqualTo("Good Morning!!");
    }

    @Test
    public void testGoodEvening() {
        assertThat(greetingService.getGoodEvening()).isEqualTo("Good Evening!!");
    }
}
