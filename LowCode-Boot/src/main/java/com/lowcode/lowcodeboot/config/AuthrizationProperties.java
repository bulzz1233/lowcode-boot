package com.lowcode.lowcodeboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//拦截器权限的设置
@Data
@Configuration
@ConfigurationProperties(prefix = "auth")
public class AuthrizationProperties {
//    不需要权限校验的url列表
    private List<String> ignoreUrls;
}
