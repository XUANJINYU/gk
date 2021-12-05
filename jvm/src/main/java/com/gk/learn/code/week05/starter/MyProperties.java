package com.gk.learn.code.week05.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.xh")
public class MyProperties {

	private Integer id;

	private String name;
}
