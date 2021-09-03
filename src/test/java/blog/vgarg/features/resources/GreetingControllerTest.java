package blog.vgarg.features.resources;

import blog.vgarg.features.exceptions.FeatureNotEnabledException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class GreetingControllerTest {

    @Autowired
    private GreetingController greetingController;

    @Test
    public void testHello() {
        ResponseEntity<String> response = greetingController.getHello();
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello!!");
    }

    @Test
    public void testGoodMorning() {
        ResponseEntity<String> response = greetingController.getGoodMorning();
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Good Morning!!");
    }

    @Test
    public void testGoodEvening() {
        assertThrows(FeatureNotEnabledException.class, () -> greetingController.getGoodEvening());
    }
}
