package blog.vgarg.features.aspect;

import blog.vgarg.features.annotations.CheckFeatureFlag;
import blog.vgarg.features.exceptions.FeatureNotEnabledException;
import blog.vgarg.features.services.featureflag.FeatureFlagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class FeatureFlagAspectTest {

    private FeatureFlagAspect featureFlagAspect;
    private FeatureFlagService featureFlagService;
    private CheckFeatureFlag checkFeatureFlag;

    @BeforeEach
    public void setup() {
        checkFeatureFlag = mock(CheckFeatureFlag.class);
        featureFlagService = mock(FeatureFlagService.class);
        featureFlagAspect = new FeatureFlagAspect(featureFlagService);
    }

    @Test
    public void testFlagEnabled() {
        when(featureFlagService.isFeatureFlagSet("feature.test")).thenReturn(true);
        when(checkFeatureFlag.flag()).thenReturn("feature.test");
        featureFlagAspect.checkFeatureFlag(null, checkFeatureFlag);
        verify(checkFeatureFlag).flag();
        verify(featureFlagService).isFeatureFlagSet("feature.test");
    }

    @Test
    public void testFlagDisabled() {
        assertThrows(FeatureNotEnabledException.class, () -> {
            when(featureFlagService.isFeatureFlagSet("feature.test")).thenReturn(false);
            when(checkFeatureFlag.flag()).thenReturn("feature.test");
            featureFlagAspect.checkFeatureFlag(null, checkFeatureFlag);
            verify(checkFeatureFlag).flag();
            verify(featureFlagService).isFeatureFlagSet("feature.test");
        });
    }
}
