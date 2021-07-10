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
import User.domain.PageBean;
import User.domain.User;

import java.util.List;
import java.util.Map;

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

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleSelectUser(String[] uids) {
        if(uids != null && uids.length > 0){
            for (String id : uids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int rows = Integer.parseInt(_rows);
        int currentPage = Integer.parseInt(_currentPage);
        //1.创建空的PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        //2.设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        //3.调用dao查询总记录，得到所需的参数
        int totalCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        System.out.println(totalCount);
        //4.调用 dao 查询 List 集合
        //计算开始的记录索引
        int start = (currentPage - 1)* rows;
        List<User> list = dao.findUserByPage(start,rows,condition);
        pageBean.setList(list);

        //5.计算总页码
        int totalPage = totalCount % rows ==0 ? totalCount / rows : totalCount / rows + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}