package com.sb.hyh.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.sb.hyh.entities.Student;

@Service
public class StudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getList() {
        String sql = "SELECT ID,NAME,SUM,AVG,AGE,STATUS FROM STUDENT";
        return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student stu = new Student();
                stu.setId(rs.getInt("ID"));
                stu.setAge(rs.getInt("AGE"));
                stu.setName(rs.getString("NAME"));
                stu.setSum(rs.getFloat("SUM"));
                stu.setAvg(rs.getFloat("AVG"));
                stu.setStatus(rs.getString("STATUS"));
                return stu;
            }
        });
    }
}