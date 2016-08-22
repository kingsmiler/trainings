package org.xman.trainings.spring.config.beetl;

import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

@Configuration
public class BeetlBeanConfig {
    @Value("${beetl.content-type}")
    private String contentType = "text/html;charset=UTF-8";
    @Value("${beetl.prefix}")
    private String prefix;
    @Value("${beetl.suffix}")
    private String suffix = ".html";

    @Bean(initMethod = "init")
    public BeetlGroupUtilConfiguration beetlConfig() {
        return new BeetlGroupUtilConfiguration();
    }

    @Bean
    public ViewResolver viewResolver() {
        BeetlSpringViewResolver resolver = new BeetlSpringViewResolver();
        resolver.setPrefix(prefix);
        resolver.setSuffix(suffix);
        resolver.setContentType(contentType);
        resolver.setOrder(0);

        return resolver;
    }
}
