package com.gk.learn.code.week05;

import com.gk.learn.code.week05.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

	@Test
	public void test() {
		// xml
		ApplicationContext context = new ClassPathXmlApplicationContext("BeanConfig.xml");
		Student student = context.getBean(Student.class);
		System.out.println(student);

		// component
		ApplicationContext context1 = new AnnotationConfigApplicationContext(AnnotationComponent.class);
		AnnotationComponent component= context1.getBean(AnnotationComponent.class);
		component.ding();

		// Configuration
		ApplicationContext context2 = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		Student student1= context2.getBean(Student.class);
		System.out.println(student1);
	}
}
