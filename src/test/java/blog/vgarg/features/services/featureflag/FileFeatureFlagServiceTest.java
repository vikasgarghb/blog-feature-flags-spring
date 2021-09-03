package blog.vgarg.features.services.featureflag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class FileFeatureFlagServiceTest {
    private FeatureFlagService featureFlagService;

    @BeforeEach
    public void setup() throws IOException {
        featureFlagService = new FileFeatureFlagService();
    }

    @Test
    public void testIsFeatureFlagSet() {
        assertThat(featureFlagService.isFeatureFlagSet("flags.goodmorning")).isTrue();
    }
}
