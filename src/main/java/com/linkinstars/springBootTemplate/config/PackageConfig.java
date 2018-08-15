package com.linkinstars.springBootTemplate.config;

import com.linkinstars.springBootTemplate.SpringBootTemplateApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 打war包所需要使用的工具类
 * @author LinkinStar
 */
@ConditionalOnProperty(name = "package.type", havingValue = "war")
public class PackageConfig extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(SpringBootTemplateApplication.class);
    }
}
