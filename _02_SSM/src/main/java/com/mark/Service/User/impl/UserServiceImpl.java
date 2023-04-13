package com.mark.Service.User.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mark.Common.Result.PageResult;
import com.mark.Dal.UserDao;
import com.mark.Model.User;
import com.mark.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有用户信息
     * @return List<User>
     */
    public List<User> selectUserAll()
    {
        return userDao.selectUserAll();
    }

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return User
     */
    public User GetUserByID(Integer id)
    {
        return userDao.GetUserByID(id);
    }

    /**
     * 分页查询
     * @param pageCount 查询条数
     * @param pageNum 查询页数
     * @return
     */
    public PageResult PageUserList(Integer pageCount,Integer pageNum)
    {
        PageHelper.startPage(pageNum,pageCount);
        List<User> users = userDao.selectUserAll();
        PageInfo pageInfo = new PageInfo(users);
        return new PageResult(pageInfo.getPageNum(),pageInfo.getPageSize(), (int) pageInfo.getTotal(),pageInfo.getPages(),users);
    }

    /**
     * 添加用户信息
     * @param user 要添加用户信息
     * @return true:执行成功 false：执行失败
     */
    @Transactional
    public boolean UserAdd(User user)
    {
        return userDao.UserAdd(user);
    }

    /**
     * 修改用户信息
     * @param user 要修改用户信息
     * @return true:执行成功 false：执行失败
     */
    @Transactional
    public boolean UserUpd(User user)
    {
        return userDao.UserUpd(user);
    }

    /**
     * 删除用户信息
     * @param ids 要删除用户的id集合
     * @return true:执行成功 false：执行失败
     */
    @Transactional
    public boolean UserDel(String[] ids)
    {
        return userDao.UserDel(ids);
    }

    /**
     * 测试添加多条记录事务
     */
    @Transactional
    public void testUserAdds()
    {
        userDao.UserAdd(new User("1","test1","男","25","北京","189076271"));
        System.out.println(1/0);
        userDao.UserAdd(new User("1","test2","男","26","石家庄","188006278"));
        userDao.UserAdd(new User("1","test3","男","27","天津","1875462782"));
    }
}
