package com.msp.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;




import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class fastJsonConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonConfig config = new FastJsonConfig();

        config.setSerializerFeatures(
                // 保留map空的字段
                SerializerFeature.WriteMapNullValue,
                // 将String类型的null转成""
                SerializerFeature.WriteNullStringAsEmpty,
                // 将Number类型的null转成0
                SerializerFeature.WriteNullNumberAsZero,
                // 将List类型的null转成[]
                SerializerFeature.WriteNullListAsEmpty,
                // 将Boolean类型的null转成false
                SerializerFeature.WriteNullBooleanAsFalse,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect);

        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces="application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypeList);
        converters.add(fastJsonHttpMessageConverter);

    }
}
