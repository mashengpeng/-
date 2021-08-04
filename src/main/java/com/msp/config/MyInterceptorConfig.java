package com.msp.config;

import com.msp.handler.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}

//@Configuration
//public class MyInterceptorConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//    // 实现WebMvcConfigurer不会导致静态资源被拦截
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
//    }
//}
