package com.zh.boot.launch.entities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Component
/**
 * 使对象验证注解生效
 */
@Validated
@ConfigurationProperties(prefix = "family")
public class Family {

    //    @Value("${family.family-name}")
    @NotEmpty
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;

}
