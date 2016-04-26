package com.sb.hyh.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hyh.entities.DemoEntity;
import com.sb.hyh.entities.Page;
import com.sb.hyh.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {
	/**
	 * 注入业务层
	 */
	@Autowired
	private DemoService demoService;

	@RequestMapping("/addOne")
	public void addOne() {
		DemoEntity demo = new DemoEntity();
		demo.setName("demo");
		demo.setIntro("demo is a insertOne test!");

		demoService.addOne(demo);
	}

	@RequestMapping("/addList")
	public void addList() {
		List<DemoEntity> demolist = new ArrayList<DemoEntity>();
		DemoEntity demo1 = new DemoEntity();
		demo1.setName("demo");
		demo1.setIntro("demo is a insertList test!");
		demolist.add(demo1);
		DemoEntity demo2 = new DemoEntity();
		demo2.setName("demo");
		demo2.setIntro("demo is a insertList test!");
		demolist.add(demo2);
		DemoEntity demo3 = new DemoEntity();
		demo3.setName("demo");
		demo3.setIntro("demo is a insertList test!");
		demolist.add(demo3);

		demoService.addList(demolist);
	}

	@RequestMapping("/remove")
	public void remove() {
		int id = 48;

		demoService.remove(id);
	}

	@RequestMapping("/removeIn")
	public void removeIn() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(42);
		ids.add(49);
		ids.add(46);

		demoService.removeIn(ids);
	}

	@RequestMapping("/modify")
	public void modify() {
		DemoEntity demo = new DemoEntity();
		demo.setId(6);
		demo.setName("demoUpdate");
		demo.setIntro("demo is a updateDemo test!");

		demoService.modify(demo);
	}

	/**
	 * 查找单条,不存在返回null
	 */
	@RequestMapping("/queryOne")
	public DemoEntity queryOne() {
		int id = 7;

		return demoService.queryOne(id);
	}

	/**
	 * 多条查询,不存在返回[]空数组
	 */
	@RequestMapping("/queryList")
	public List<DemoEntity> queryList() {
		String name = "demo";

		return demoService.queryList(name);
	}

	/**
	 * 分页查询
	 */
	@RequestMapping("/queryPage")
	public Page<DemoEntity> queryPage() {
		int page = 2;
		int size = 2;
		Page<DemoEntity> pager = new Page<DemoEntity>(page, size);
		String name = "demo";
		List<String> ids = new ArrayList<>();
		ids.add("2");
		ids.add("45");
		ids.add("5");
		ids.add("6");
		ids.add("7");

		return demoService.queryPage(name, ids, pager);
	}

	/**
	 * 分页查询
	 */
	@RequestMapping("/queryPage2")
	public Page<DemoEntity> queryPage2() {
		int page = 2;
		int size = 2;
		Page<DemoEntity> pager = new Page<DemoEntity>(page, size);

		return demoService.queryPage(pager);
	}

	/**
	 * 事务测试
	 */
	@RequestMapping("/transaction")
	public void transaction() {
		demoService.transaction();
	}
}
