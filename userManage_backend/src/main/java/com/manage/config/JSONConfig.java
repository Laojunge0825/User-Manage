package com.manage.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @ClassName: JSONConfig
 * @Description:   后端传long类型的值给前端，当数据大于17位时。前端第16位会四舍五入，17位后的用0代替。在Json中会出现精度丢失的情况
 *                第二种  全局配置 将所有的Long类型的字段序列化成为字符串。  翻页中的total pageSize  pageNum都是long类型的字段
 *                转为字符串后会失效
 * @author: 舒克、舒克
 * @Date: 2024/11/12 11:24
 */

@Configuration
public class JSONConfig {

    /*
     * @Author 舒克、舒克
     * @Description   添加 Long 转 json 精度丢失的配置
     * @Date 11:27 2024/11/12
     * @Param
     * @return
     **/
    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(module);
        return objectMapper;
    }

}
