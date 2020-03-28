package com.api.apitest.boot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot通过@ConditionalOnProperty来控制Configuration是否生效
 * @author zengxueqi
 * @since 2020/3/28
 */
public class JulyDocConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "julydoc", name = "enable", matchIfMissing = true)
    public JulyDocSpringController julyDocController() {
        return new JulyDocSpringController();
    }

}
