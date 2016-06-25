package com.sb.hyh.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.core.DummyInvocationUtils;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sb.hyh.vo.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		// GreetingController methodOn =
		// ControllerLinkBuilder.methodOn(GreetingController.class);
		GreetingController methodOn = DummyInvocationUtils.methodOn(GreetingController.class);

		Greeting greeting2 = methodOn.greeting(name);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(greeting2);
		Link withSelfRel = linkTo.withSelfRel();
		greeting.add(withSelfRel);

		return greeting;
	}

	@RequestMapping("/show")
	public Greeting show() {
		RestTemplate template = new RestTemplate();
		Greeting greeting = template.getForObject("http://localhost:8080/greeting?name=323", Greeting.class);
		System.out.println(greeting);
		return greeting;
	}
}