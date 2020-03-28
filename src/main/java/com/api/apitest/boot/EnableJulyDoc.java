package com.api.apitest.boot;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于开启July Doc Api测试功能
 * @author zengxueqi
 * @since 2020/3/28
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(JulyDocConfiguration.class)
public @interface EnableJulyDoc {
}
