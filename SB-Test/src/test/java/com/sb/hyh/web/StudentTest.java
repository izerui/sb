//package com.sb.hyh.web;
//
//import static org.junit.Assert.assertArrayEquals;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.sb.hyh.Application;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//public class StudentTest {
//	@Autowired
//	private StudentService studentService;
//
//	@Test
//	public void likeName() {
//		assertArrayEquals(new Object[] { studentService.likeName("小明2").size() > 0,
//				studentService.likeName("坏").size() > 0, studentService.likeName("莉莉").size() > 0 },
//				new Object[] { true, false, true });
//		// assertTrue(studentService.likeName("小明2").size() > 0);
//	}
//}