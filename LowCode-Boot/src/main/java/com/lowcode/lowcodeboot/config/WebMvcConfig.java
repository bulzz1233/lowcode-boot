package com.lowcode.lowcodeboot.config;

import com.lowcode.lowcodeboot.interceptor.AuthrizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

//自定义的webmvc配置
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private AuthrizationProperties authrizationProperties;

    @Bean
    public AuthrizationInterceptor authrizationInterceptor() {
        return new AuthrizationInterceptor();
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authrizationInterceptor())
                //拦截所有路径
                .addPathPatterns("/**")
                //排除的
                .excludePathPatterns(authrizationProperties.getIgnoreUrls());
    }
//    配置允许跨域

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600);
    }
}
