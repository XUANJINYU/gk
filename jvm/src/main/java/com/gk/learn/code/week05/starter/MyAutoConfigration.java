package com.gk.learn.code.week05.starter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties(MyProperties.class)
public class MyAutoConfigration {

	@Resource
	private MyProperties properties;

	public void showProperties()
	{
		System.out.println("配置开始  id:"+properties.getId()
				+" name:"+properties.getName());
	}

}
