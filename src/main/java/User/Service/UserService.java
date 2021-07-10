package User.Service;

import User.domain.PageBean;
import User.domain.User;

import java.util.List;
import java.util.Map;

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

    /**
     * @Description: 根据id删除
     * @param id
     */
    void deleteUser(String id);

    /**
     * @Description: 根据ID查找用户信息
     * @param id
     * @return User
     */
    User findUserById(String id);

    /**
     * @Description: 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * @Description: 多选删除
     * @param uids
     */
    void deleSelectUser(String[] uids);

    /**
     * @Description: 分页条件查询
     * @param currentPage,rows
     * @param condition
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
