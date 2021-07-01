package User.Dao;

import User.domain.User;

import java.util.List;

/**
 * @title 用户操作的Dao
 * @data 2021/6/8
 */
public interface UserDao {
    public List<User> findAll();

    void add(User user);
}
