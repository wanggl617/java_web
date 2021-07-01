/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package User.Service;

import User.Dao.UserDao;
import User.Dao.UserDaoImpl;
import User.domain.User;

import java.util.List;

/**
 * @title 阳光正好，微风不燥
 * @data 2021/6/8
 */
public class UserServiceImpl implements UserService{
    private UserDao dao = new UserDaoImpl();
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }
}