package com.mark.Dal;

import com.mark.Model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户信息
     * @return 所有用户信息
     */
    List<User> selectUserAll();

    /**
     * 根据用户id查询用户信息
     * @param id 用户id
     * @return 用户信息
     */
    User GetUserByID(@Param("id")Integer id);

    /**
     * 添加用户信息
     * @param user 要添加用户信息
     * @return true:执行成功 false：执行失败
     */
    Boolean UserAdd(User user);

    /**
     * 修改用户信息
     * @param user 要修改用户信息
     * @return true:执行成功 false：执行失败
     */
    Boolean UserUpd(User user);

    /**
     * 删除用户信息
     * @param ids 要删除用户的id集合
     * @return true:执行成功 false：执行失败
     */
    Boolean UserDel(@Param("ids")String[] ids);
}
