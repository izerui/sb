package com.sb.hyh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hyh.entity.DemoEntity;
import com.sb.hyh.entity.Pager;
import com.sb.hyh.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	private DemoService demoService;

	@RequestMapping("/addOne")
	public void addOne() {
		DemoEntity demo = new DemoEntity();
		demo.setName("demo");
		demo.setIntro("this is a addOne demo!");

		demoService.addOne(demo);
	}

	@RequestMapping("/addList")
	public void addList() {
		List<DemoEntity> demos = new ArrayList<DemoEntity>();
		DemoEntity demo1 = new DemoEntity();
		demo1.setName("demo");
		demo1.setIntro("this is a addList demo!");
		demos.add(demo1);
		DemoEntity demo2 = new DemoEntity();
		demo2.setName("demo");
		demo2.setIntro("this is a addList demo!");
		demos.add(demo2);

		demoService.addList(demos);
	}

	@RequestMapping("/remove")
	public void remove() {
		String intro = "this is a addOne demo!";

		demoService.remove(intro);
	}

	@RequestMapping("/removeIn")
	public void removeIn() {
		List<String> list = new ArrayList<String>();
		list.add("this is a addOne demo!");
		list.add("this is a addList demo!");

		demoService.removeIn(list);
	}

	@RequestMapping("/modify")
	public void modify() {
		DemoEntity demo = new DemoEntity();
		demo.setName("demo");
		demo.setIntro("this is a modifyOne demo!");

		demoService.modify(demo);
	}

	@RequestMapping("/queryOne")
	public DemoEntity queryOne() {
		String name = "demo";

		return demoService.queryOne(name);
	}

	@RequestMapping("/queryList")
	public List<DemoEntity> queryList() {
		String name = "demo";

		return demoService.queryList(name);
	}

	@RequestMapping("/queryPage")
	public Pager<DemoEntity> queryPage() {
		int page = 1;
		int size = 4;
		String name = "demo";
		Pager<DemoEntity> pager = new Pager<DemoEntity>(page, size);

		return demoService.queryPage(name, pager);
	}

	@RequestMapping("/groupBy")
	public void groupBy() {
		demoService.groupBy();
	}
}
