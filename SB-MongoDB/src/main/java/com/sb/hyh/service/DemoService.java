package com.sb.hyh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.hyh.dao.DemoDao;
import com.sb.hyh.entity.DemoEntity;
import com.sb.hyh.entity.Pager;

@Service
public class DemoService {
	@Autowired
	private DemoDao demoDao;

	public void addOne(DemoEntity demo) {
		demoDao.addOne(demo);
	}

	public void addList(List<DemoEntity> demos) {
		demoDao.addList(demos);
	}

	public void remove(String intro) {
		demoDao.remove(intro);
	}

	public void removeIn(List<String> list) {
		demoDao.removeIn(list);
	}

	public void modify(DemoEntity demo) {
		demoDao.modify(demo);
	}

	public DemoEntity queryOne(String name) {
		return demoDao.queryOne(name);
	}

	public List<DemoEntity> queryList(String name) {
		return demoDao.queryList(name);
	}

	public Pager<DemoEntity> queryPage(String name, Pager<DemoEntity> pager) {
		return demoDao.queryPage(name, pager);
	}

	public void groupBy() {
		demoDao.groupBy();
	}
}
