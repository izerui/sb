package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.hyh.listener.MyApplicationEnvironmentPreparedEventListener;
import com.sb.hyh.listener.MyApplicationFailedEventListener;
import com.sb.hyh.listener.MyApplicationPreparedEventListener;
import com.sb.hyh.listener.MyApplicationStartedEventListener;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.addListeners(new MyApplicationStartedEventListener());
		app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
		app.addListeners(new MyApplicationPreparedEventListener());
		app.addListeners(new MyApplicationFailedEventListener());
		app.run(args);
	}
}
