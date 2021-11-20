package com.gk.learn;

import com.gk.learn.code.week03.router.WeightRouter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/")
@RestController
@SpringBootApplication
public class JvmApplication {

	public static void main(String[] args) {
		SpringApplication.run(JvmApplication.class, args);
	}

}
