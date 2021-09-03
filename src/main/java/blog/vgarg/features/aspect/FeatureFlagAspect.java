package blog.vgarg.features.aspect;

import blog.vgarg.features.annotations.CheckFeatureFlag;
import blog.vgarg.features.exceptions.FeatureNotEnabledException;
import blog.vgarg.features.services.featureflag.FeatureFlagService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FeatureFlagAspect {

    private FeatureFlagService featureFlagService;

    public FeatureFlagAspect(FeatureFlagService featureFlagService) {
        this.featureFlagService = featureFlagService;
    }

    @Before("execution (* blog.vgarg.features..*(..)) && @annotation(checkFeatureFlag)")
    public void checkFeatureFlag(JoinPoint joinPoint, CheckFeatureFlag checkFeatureFlag) {
        String flag = checkFeatureFlag.flag();
        if (!featureFlagService.isFeatureFlagSet(flag)) {
            throw new FeatureNotEnabledException();
        }
    }
}
