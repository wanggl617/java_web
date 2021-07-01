/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package User.Dao;

import User.Utils.JDBCUtils;
import User.domain.Login_User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @title 阳光正好，微风不燥
 * @data 2021/6/9
 */
public class LoginDao {
    private static JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    public Login_User login(Login_User user){

        String sql = "SELECT * FROM login WHERE USERNAME=? AND PASSWORD=?";
        Login_User loginUser = null;
        try {
            loginUser=template.queryForObject(sql,
                    new BeanPropertyRowMapper<Login_User>(Login_User.class),
                    user.getUsername(),
                    user.getPassword());
        } catch (DataAccessException e) {
            return null;
        }

        return loginUser;
    }
}