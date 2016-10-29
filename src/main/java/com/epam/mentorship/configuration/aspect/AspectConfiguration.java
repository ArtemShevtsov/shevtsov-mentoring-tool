package com.epam.mentorship.configuration.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by aftor on 09.10.16.
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfiguration {
}
