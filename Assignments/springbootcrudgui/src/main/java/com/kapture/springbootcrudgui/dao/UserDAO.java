package com.kapture.springbootcrudgui.dao;

import com.kapture.springbootcrudgui.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        return jdbcTemplate.query("select * from user", new RowMapper<User>() {
            public User mapRow(ResultSet rs, int row) throws SQLException {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setName(rs.getString(3));
                user.setPassword(rs.getString(4));
                return user;
            }
        });
    }

    public User findById(Integer id) {
        String query = "select * from user where id=?";
        return jdbcTemplate.queryForObject(query, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
    }

    public int save(User user) {
        String query = "insert into user(email, name, password) values ('"+user.getEmail()+"','"+user.getName()+"','"+user.getPassword()+"')";
        return jdbcTemplate.update(query);
    }

    public int update(User user) {
        String query = "update user set email='"+user.getEmail()+"', name='"+user.getName()+"',password='"+user.getPassword()+"' where id="+user.getId()+"";
        return jdbcTemplate.update(query);
    }

    public int deleteById(Integer id) {
        String query = "delete from user where id=" + id + "";
        return jdbcTemplate.update(query);
    }
}