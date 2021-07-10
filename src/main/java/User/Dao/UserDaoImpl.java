/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package User.Dao;

import User.Utils.JDBCUtils;
import User.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

/**
 * @title 阳光正好，微风不燥
 * @data 2021/6/8
 */
public class UserDaoImpl implements UserDao{
    private JdbcTemplate template= new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql = "SELECT * FROM user ";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void add(User user) {
        //1.定义sql
        String sql = "INSERT INTO user VALUES ( NULL, ?, ?,?, ?,?,?)";
        //2.执行sql
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail()) ;

        }

    @Override
    public void delete(int parseInt) {
        //1.定义sql
        String sql = "DELETE FROM user WHERE ID = ?";
        //2.执行sql
        template.update(sql,parseInt);
    }

    @Override
    public User findUserById(int parseInt) {
        //1.定义sql
        String sql =  "SELECT * FROM user WHERE ID = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), parseInt);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE  user SET name = ?,GENDER =?,AGE = ?,ADDRESS = ?,QQ =?,EMAIL =? WHERE ID = ?;";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());

    }

    /**
     * 对输入条件进行查询
     * @param condition
     * @return
     */
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "SELECT COUNT(*) FROM user WHERE 1=1";
        StringBuilder tiaojian = new StringBuilder(sql);
        //遍历Map
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>(); //参数的集合
        for(String key:keySet){
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取 value
            String value = condition.get(key)[0];
            if(value != null && !"".equals(value)){
                //有值
                tiaojian.append(" and " + key + " LIKE ? ");
                params.add("%"+value+"%");//存在参数，加入参数集合
            }
        }
        System.out.println(tiaojian.toString());
        System.out.println(params);
        return template.queryForObject(tiaojian.toString(), Integer.class,params.toArray());//params.toArray()把参数列表转换为可变数组
    }

    /**
     * 具体进行分页查询操作
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    @Override
    public List<User> findUserByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "SELECT * FROM user WHERE 1=1";
        StringBuilder tiaojian = new StringBuilder(sql);
        //遍历Map
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>(); //参数的集合
        for(String key:keySet){
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取 value
            String value = condition.get(key)[0];
            if(value != null && !"".equals(value)){
                //有值
                tiaojian.append(" and " + key + " LIKE ? ");
                params.add("%"+value+"%");//存在参数，加入参数集合
            }
        }
        //添加分页查询
        tiaojian.append(" limit ?,?");
        //添加分页查询的参数
        params.add(start);
        params.add(rows);
        System.out.println("_________________");
        System.out.println(tiaojian.toString());
        System.out.println(params);
        return template.query(tiaojian.toString(), new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }


}