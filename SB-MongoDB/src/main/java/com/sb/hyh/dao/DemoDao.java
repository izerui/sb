package com.sb.hyh.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.sb.hyh.entity.DemoEntity;
import com.sb.hyh.entity.Pager;

@Repository
public class DemoDao {

	@Autowired
	private MongoTemplate template;

	public void addOne(DemoEntity demo) {
		template.save(demo);
	}

	public void addList(List<DemoEntity> demos) {
		template.insert(demos, DemoEntity.class);
	}

	public void remove(String intro) {
		Query query = new Query(Criteria.where("intro").is(intro));
		template.remove(query, DemoEntity.class);
	}

	public void removeIn(List<String> list) {
		Query query = new Query(Criteria.where("intro").in(list));
		template.remove(query, DemoEntity.class);
	}

	public void modify(DemoEntity demo) {
		Query query = new Query(Criteria.where("name").is(demo.getName()));
		Update update = new Update().set("intro", demo.getIntro());
		// 更新满足条件的第一条
		template.updateFirst(query, update, DemoEntity.class);
		// 满足条件的全部更新
		// template.updateMulti(query, update, DemoEntity.class);
	}

	public DemoEntity queryOne(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		return template.findOne(query, DemoEntity.class);
	}

	public List<DemoEntity> queryList(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		return template.find(query, DemoEntity.class);
	}

	public Pager<DemoEntity> queryPage(String name, Pager<DemoEntity> pager) {
		// 总数
		Query query = new Query(Criteria.where("name").is(name));
		int count = (int) template.count(query, DemoEntity.class);
		// 分页信息PageRequest(从0开始,每页数)
		Pageable pageable = new PageRequest(pager.getPage() - 1, pager.getSize(), new Sort("id"));
		query = query.with(pageable);
		List<DemoEntity> list = template.find(query, DemoEntity.class);
		// 组装pager
		pager.setResult(list);
		pager.setTotal(count);
		pager.setEndNo();
		return pager;
	}

	@SuppressWarnings("unchecked")
	public void groupBy() {
		GroupBy groupBy = GroupBy
				// groupBy的字段
				.key("")
				// 初始化字段
				.initialDocument("{name: '',total: 0 }")
				// obj:查询到的每一条数据
				// result:初始化字段 ,处理后返回
				.reduceFunction(
						"function(obj, result) { " + "  result.name += obj.name; " + "  result.total += 1; " + "}");

		GroupByResults<DemoEntity> groupByResults = template.group(new Criteria(), "demo", groupBy, DemoEntity.class);
		DBObject rawResults = groupByResults.getRawResults();

		// 结果：[{'groupBykey1','初始化字段1','初始化字段2'},{'groupBykey2','初始化字段1','初始化字段2'}]
		// groupBykey定义为空则[ { "" : null , "初始化字段1" : "..." , "初始化字段2" : ""...}]
		System.out.println(rawResults.toString());
		List<Map<String, Object>> result = (List<Map<String, Object>>) rawResults.get("retval");
		System.out.println(result);
	}
}
