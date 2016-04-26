package com.sb.hyh.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sb.hyh.entities.Page;

public class BaseDao {

	private static final Logger logger = Logger.getLogger(BaseDao.class);

	@Autowired
	protected JdbcTemplate template;

	/**
	 * 插入单实体,通过反射机制获取实体中每个属性值并塞给参数数组
	 * 
	 * @param sql
	 *            INSERT INTO DEMO (name, intro) VALUES
	 * @param t
	 *            实体
	 * @param args
	 *            实体中的属性
	 */
	protected <T> void insertListOne(StringBuffer sql, T t, String[] args) {
		StringBuffer sb = new StringBuffer("(");
		int len = args.length;
		for (int i = 0; i < len; i++) {
			sb.append("?,");
		}
		String paramsStr = sb.substring(0, sb.length() - 1) + ")";
		List<Object> params = new ArrayList<Object>();
		Class<? extends Object> clazz = t.getClass();
		try {
			for (String string : args) {
				PropertyDescriptor pd;
				pd = new PropertyDescriptor(string, clazz);
				Method getMethod = pd.getReadMethod();// 获得get方法
				Object o = getMethod.invoke(t);// 执行get方法返回一个Object
				params.add(o);
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		template.update(sql.append(paramsStr).toString(), params.toArray());
	}

	/**
	 * 插入list,通过反射机制获取实体list中每个单体属性值并塞给参数数组
	 * 
	 * @param sql
	 *            INSERT INTO DEMO (name, intro) VALUES
	 * @param list
	 *            实体list
	 * @param args
	 *            实体中的属性
	 */
	protected <T> void insertList(StringBuffer sql, List<T> list, String[] args) {
		StringBuffer sb = new StringBuffer("(");
		int len = args.length;
		for (int i = 0; i < len; i++) {
			sb.append("?,");
		}
		String paramsStr = sb.substring(0, sb.length() - 1) + "),";
		List<Object> params = new ArrayList<Object>();
		try {
			for (T t : list) {
				sql.append(paramsStr);
				// 获取实体类的所有属性,返回Field数组
				Class<? extends Object> clazz = t.getClass();
				for (String string : args) {
					PropertyDescriptor pd;
					pd = new PropertyDescriptor(string, clazz);
					Method getMethod = pd.getReadMethod();// 获得get方法
					Object o = getMethod.invoke(t);// 执行get方法返回一个Object
					params.add(o);
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		template.update(sql.substring(0, sql.length() - 1), params.toArray());
	}

	/**
	 * 根据ids多个删除
	 */
	public void deleteMul(String sql, List<Integer> ids) {
		StringBuffer buffer = new StringBuffer();
		for (Integer id : ids) {
			buffer.append("," + id);
		}
		sql = sql.replace("?", buffer.substring(1));
		template.execute(sql);
	}

	/**
	 * 查询实体
	 */
	public <T> T queryForObject(String sql, Object[] args, final Class<T> clazz) {
		List<T> t = queryForList(sql, args, clazz);
		if (t.size() == 0) {
			return null;
		}
		return t.get(0);
	}

	/**
	 * 查询list
	 */
	public <T> List<T> queryForList(String sql, Object[] args, final Class<T> t) {
		List<T> list = template.query(sql, args, new RowMapper<T>() {
			@Override
			public T mapRow(ResultSet rs, int arg1) throws SQLException {
				T tt = null;
				try {
					tt = (T) getField(rs, t);
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
						| InstantiationException | InvocationTargetException e) {
					logger.info("查询list错误");
				}
				return tt;
			}
		});
		return list;
	}

	/**
	 * 查询List<Map<String, Object>>
	 */
	public List<Map<String, Object>> queryForMapList(String sql, Object[] args) {
		List<Map<String, Object>> list = template.query(sql, args, new RowMapper<Map<String, Object>>() {
			@Override
			public Map<String, Object> mapRow(ResultSet rs, int arg1) throws SQLException {
				Map<String, Object> heads = new HashMap<String, Object>();
				ResultSetMetaData rsmd = rs.getMetaData();// rs为查询结果集
				int count = rsmd.getColumnCount();
				for (int i = 1; i <= count; i++) {
					heads.put(rsmd.getColumnLabel(i), rs.getObject(rsmd.getColumnLabel(i)));// 把列名存入向量heads中
				}
				return heads;
			}
		});
		return list;
	}

	/**
	 * 分页
	 */
	public <T> Page<T> queryForPage(String sql, Object[] args, Page<T> page, final Class<T> t) {
		String sqlCount = "select count(1) from (" + sql + ") A";
		int count = template.queryForObject(sqlCount, args, Integer.class);
		page.setTotal(count);
		page.setEndNo();

		String sqlLimit = sql + " limit " + page.getStartNo() + "," + page.getSize();
		List<T> list = template.query(sqlLimit, args, new RowMapper<T>() {
			@Override
			public T mapRow(ResultSet rs, int arg1) throws SQLException {
				T tt = null;
				try {
					tt = (T) getField(rs, t);
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
						| InstantiationException | InvocationTargetException e) {
					logger.info("分页错误");
				}
				return tt;
			}
		});
		page.setResult(list);
		return page;
	}

	/**
	 * 结果集映射成实体
	 */
	private <T> T getField(ResultSet rs, Class<T> clazz)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, SQLException, InstantiationException {
		// 获取结果集
		Map<String, Object> heads = new HashMap<String, Object>();
		ResultSetMetaData rsmd = rs.getMetaData();// rs为查询结果集
		int count = rsmd.getColumnCount();
		for (int i = 1; i <= count; i++) {
			heads.put(rsmd.getColumnLabel(i), rs.getObject(rsmd.getColumnLabel(i)));// 把列名存入向量heads中
		}

		T t = (T) clazz.newInstance();
		// 遍历所有属性 并判断sql返回里存在则塞值进去
		// 获取实体类的所有属性,返回Field数组
		Field[] fields = t.getClass().getDeclaredFields();
		// 遍历所有属性
		for (Field field : fields) {
			String name = field.getName(); // 获取属性的名字
			String bigname = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写,方便构造get,set方法
			String type = field.getGenericType().toString(); // 获取属性的类型
			if (type.equals("class java.lang.String")) { // 如果type是类类型,则前面包含"class",后面跟类名
				Method m = t.getClass().getMethod("set" + bigname, String.class);
				if (heads.containsKey(name)) {
					m.invoke(t, (String) heads.get(name));
				}
			} else if (type.equals("class java.util.Date")) {
				Method m = t.getClass().getMethod("set" + bigname, Date.class);
				if (heads.containsKey(name)) {
					m.invoke(t, new java.util.Date(((java.sql.Timestamp) heads.get(name)).getTime()));
				}
			} else if (type.equals("int")) {
				Method m = t.getClass().getMethod("set" + bigname, int.class);
				if (heads.containsKey(name)) {
					Object value = heads.get(name);
					if (value == null) {
						m.invoke(t, 0);
					} else {
						m.invoke(t, (int) value);
					}
				}
			} else if (type.equals("class java.lang.Integer")) {
				Method m = t.getClass().getMethod("set" + bigname, Integer.class);
				if (heads.containsKey(name)) {
					m.invoke(t, (Integer) heads.get(name));
				}
			} else if (type.equals("boolean")) {
				Method m = t.getClass().getMethod("set" + bigname, boolean.class);
				if (heads.containsKey(name)) {
					Object value = heads.get(name);
					if (value == null) {
						m.invoke(t, false);
					} else {
						m.invoke(t, (boolean) value);
					}
				}
			} else if (type.equals("class java.lang.Boolean")) {
				Method m = t.getClass().getMethod("set" + bigname, Boolean.class);
				if (heads.containsKey(name)) {
					m.invoke(t, (Boolean) heads.get(name));
				}
			} else if (type.equals("class java.math.BigDecimal")) {
				Method m = t.getClass().getMethod("set" + bigname, BigDecimal.class);
				if (heads.containsKey(name)) {
					m.invoke(t, (BigDecimal) heads.get(name));
				}
			} else if (type.equals("double")) {
				Method m = t.getClass().getMethod("set" + bigname, double.class);
				if (heads.containsKey(name)) {
					Object value = heads.get(name);
					if (value == null) {
						m.invoke(t, 0.00);
					} else {
						m.invoke(t, (double) value);
					}
				}
			} else if (type.equals("class java.lang.Double")) {
				Method m = t.getClass().getMethod("set" + bigname, Double.class);
				if (heads.containsKey(name)) {
					m.invoke(t, (Double) heads.get(name));
				}
			} else if (type.equals("long")) {
				Method m = t.getClass().getMethod("set" + bigname, long.class);
				if (heads.containsKey(name)) {
					Object value = heads.get(name);
					if (value == null) {
						m.invoke(t, 0l);
					} else {
						m.invoke(t, (long) heads.get(name));
					}
				}
			} else if (type.equals("class java.lang.Long")) {
				Method m = t.getClass().getMethod("set" + bigname, Long.class);
				if (heads.containsKey(name)) {
					m.invoke(t, (Long) heads.get(name));
				}
			} else if (type.equals("float")) {
				Method m = t.getClass().getMethod("set" + bigname, float.class);
				if (heads.containsKey(name)) {
					Object value = heads.get(name);
					if (value == null) {
						m.invoke(t, 0.0f);
					} else {
						m.invoke(t, (float) value);
					}
				}
			} else if (type.equals("class java.lang.Float")) {
				Method m = t.getClass().getMethod("set" + bigname, Float.class);
				if (heads.containsKey(name)) {
					m.invoke(t, (Float) heads.get(name));
				}
			} else if (type.equals("char")) {
				Method m = t.getClass().getMethod("set" + bigname, char.class);
				if (heads.containsKey(name)) {
					Object value = heads.get(name);
					if (value == null) {
						m.invoke(t, 0);
					} else {
						m.invoke(t, (char) value);
					}
				}
			} else if (type.equals("class java.lang.Character")) {
				Method m = t.getClass().getMethod("set" + bigname, Character.class);
				if (heads.containsKey(name)) {
					m.invoke(t, (Character) heads.get(name));
				}
			} else if (type.equals("short")) {
				Method m = t.getClass().getMethod("set" + bigname, short.class);
				if (heads.containsKey(name)) {
					Object value = heads.get(name);
					if (value == null) {
						m.invoke(t, 0);
					} else {
						m.invoke(t, (short) value);
					}
				}
			} else if (type.equals("class java.lang.Short")) {
				Method m = t.getClass().getMethod("set" + bigname, Short.class);
				if (heads.containsKey(name)) {
					m.invoke(t, (Short) heads.get(name));
				}
			}
		}
		return t;
	}
}
