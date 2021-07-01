/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */

import User.Dao.UserDao;
import User.Dao.UserDaoImpl;
import User.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * @title 阳光正好，微风不燥
 * @data 2021/6/9
 */
public class DAOText {
    @Test
    public void TestDao(){
        UserDao dao = new UserDaoImpl();
        User all_user = new User();
        List<User> all = dao.findAll();
        for(User user :all){
            System.out.println(user);
        }
    }
}