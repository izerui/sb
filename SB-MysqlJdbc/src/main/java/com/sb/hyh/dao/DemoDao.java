package com.sb.hyh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sb.hyh.entities.DemoEntity;
import com.sb.hyh.entities.Page;

/**
 * 数据处理层 BaseDao中封装了插入单条，多条，删除多条，查询返回映射成实体，实体list，Map<key,value>的list，分页...
 */
@Repository
public class DemoDao extends BaseDao {

	public void addOne(DemoEntity demo) {
		StringBuffer sql = new StringBuffer("insert into demo(name,intro) values ");
		insertListOne(sql, demo, new String[] { "name", "intro" });
	}

	/**
	 * 封装插入多条数据
	 */
	public void addList(List<DemoEntity> demolist) {
		StringBuffer sql = new StringBuffer("INSERT INTO DEMO (name, intro) VALUES ");
		insertList(sql, demolist, new String[] { "name", "intro" });
	}

	public void remove(int id) {
		template.update("DELETE FROM DEMO WHERE id=?", new Object[] { id });
	}

	public void removeIn(List<Integer> ids) {
		deleteMul("DELETE FROM DEMO WHERE id IN (?)", ids);
	}

	public void modify(DemoEntity demo) {
		template.update("UPDATE DEMO SET NAME=?,INTRO=? WHERE ID=?",
				new Object[] { demo.getName(), demo.getIntro(), demo.getId() });
	}

	public DemoEntity queryOne(int id) {
		return queryForObject("SELECT id,name,intro FROM DEMO WHERE ID=?", new Object[] { id }, DemoEntity.class);
	}

	public List<DemoEntity> queryList(String name) {
		return queryForList("SELECT id,name,intro FROM DEMO WHERE name=?", new Object[] { name }, DemoEntity.class);
	}

	public Page<DemoEntity> queryPage(String name, List<String> ids, Page<DemoEntity> pager) {
		StringBuffer buffer = new StringBuffer();
		for (String id : ids) {
			buffer.append("," + id);
		}
		return queryForPage("SELECT id,name,intro FROM DEMO WHERE name=? and id in (" + buffer.substring(1) + ")",
				new Object[] { name }, pager, DemoEntity.class);
	}

	public Page<DemoEntity> queryPage(Page<DemoEntity> pager) {
		return queryForPage("SELECT id,name,intro FROM DEMO", null, pager, DemoEntity.class);
	}
}
