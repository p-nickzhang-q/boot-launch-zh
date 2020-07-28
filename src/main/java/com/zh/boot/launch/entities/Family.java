package com.zh.boot.launch.entities;

import com.zh.boot.launch.service.MixPropertySourceFactory;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Data
@Component
/**
 * 使对象验证注解生效
 */
@Validated
@ConfigurationProperties(prefix = "family")
@PropertySource(value = "classpath:family.yml", factory = MixPropertySourceFactory.class)
public class Family {

    //    @Value("${family.family-name}")
    @NotEmpty
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;

}
