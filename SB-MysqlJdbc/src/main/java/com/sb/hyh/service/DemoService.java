package com.sb.hyh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.hyh.dao.DemoDao;
import com.sb.hyh.entities.DemoEntity;
import com.sb.hyh.entities.Page;

/**
 * 转接层
 */
@Service
public class DemoService {
	@Autowired
	private DemoDao demoDao;

	public void addOne(DemoEntity demo) {
		demoDao.addOne(demo);
	}

	public void addList(List<DemoEntity> demolist) {
		demoDao.addList(demolist);
	}

	public void remove(int id) {
		demoDao.remove(id);
	}

	public void removeIn(List<Integer> ids) {
		demoDao.removeIn(ids);
	}

	public void modify(DemoEntity demo) {
		demoDao.modify(demo);
	}

	public DemoEntity queryOne(int id) {
		return demoDao.queryOne(id);
	}

	public List<DemoEntity> queryList(String name) {
		return demoDao.queryList(name);
	}

	/**
	 * 事务处理
	 */
	@Transactional
	public void transaction() {
		DemoEntity demo = new DemoEntity();
		demo.setName("demo");
		demo.setIntro("demo is a insertOne test!");
		demoDao.addOne(demo);
		// 抛出异常,方法回滚,若注释掉,方法成功
		Integer.parseInt("ss");
		demoDao.addOne(demo);
	}

	public Page<DemoEntity> queryPage(String name, List<String> ids, Page<DemoEntity> pager) {
		return demoDao.queryPage(name, ids, pager);
	}

	public Page<DemoEntity> queryPage(Page<DemoEntity> pager) {
		return demoDao.queryPage(pager);
	}
}
