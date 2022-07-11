package cn.showcon.boot.custom;

import org.springdoc.core.customizers.DelegatingMethodParameterCustomizer;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/6/29
 */
@Component
public class MqlParameterCustomizer implements DelegatingMethodParameterCustomizer {
    @Override
    public void customize(MethodParameter originalParameter, MethodParameter methodParameter) {

    }
}
