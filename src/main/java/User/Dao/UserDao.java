package User.Dao;

import User.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @title 用户操作的Dao
 * @data 2021/6/8
 */
public interface UserDao {

    public List<User> findAll();

    void add(User user);

    void delete(int parseInt);

    User findUserById(int parseInt);

    void updateUser(User user);
    //查询所有的记录
    int findTotalCount(Map<String, String[]> condition);
    //分页查询 每页记录
    List<User> findUserByPage(int start, int rows, Map<String, String[]> condition);
}
