package org.xman.trainings.spring.config.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath*:/META-INF/spring/*-config.xml"})
public class SpringRootConfig {
}
