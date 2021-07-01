package User.Service;

import User.domain.User;

import java.util.List;

/**
 * @title 用户管理业务接口
 * @data 2021/6/8
 */
public interface UserService {
    /**
    * @Description: 查询所有用户信息
    * @return: java.util.List<User.domain.User>
    */
    public List<User> findAll();
    /**
    * @Description: 保存User对象
    * @Param: [user]
    * @return: void
    */
    void addUser(User user);
}
