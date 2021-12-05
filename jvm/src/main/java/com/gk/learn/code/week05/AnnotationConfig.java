package com.gk.learn.code.week05;

import com.gk.learn.code.week05.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AnnotationConfig {

	@Bean(name = "student1")
	@Primary
	public Student initStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("wxh");
		return student;
	}

}
