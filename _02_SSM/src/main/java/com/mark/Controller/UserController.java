package com.mark.Controller;

import com.mark.Common.Result.PageResult;
import com.mark.Common.Result.RestResult;
import com.mark.Common.Result.ResultStatus;
import com.mark.Model.User;
import com.mark.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/GetUserByID/{id}")
    public RestResult GetUserByID(@PathVariable("id")Integer id)
    {
        User user = userService.GetUserByID(id);
        if (user == null)
        {
            return new RestResult(ResultStatus.NG,"查询无此用户信息",user);
        }
        return new RestResult(ResultStatus.OK,"查询用户信息成功",user);
    }

    @PostMapping("/GetUserByID")
    public RestResult GetUserByID()
    {
        List<User> users = userService.selectUserAll();
        System.out.println(1/0);
        if (users == null)
        {
            return new RestResult(ResultStatus.NG,"查询失败",users);
        }
        return new RestResult(ResultStatus.OK,"查询成功",users);
    }

    @RequestMapping("/GetPageUserList/{pagecount}/{pagenum}")
    public RestResult GetPageUserList(@PathVariable("pagecount")Integer pageCount, @PathVariable("pagenum")Integer pageNum)
    {
        PageResult pageResult = userService.PageUserList(pageCount,pageNum);
        if (pageResult == null)
        {
            return new RestResult(ResultStatus.NG,"分页查询失败",pageResult);
        }
        return new RestResult(ResultStatus.OK,"分页查询成功",pageResult);
    }

    @PostMapping("/SetUserAdd")
    public RestResult SetUserAdd(@RequestBody User user)
    {
        if (!userService.UserAdd(user))
        {
            return new RestResult(ResultStatus.NG,"录入失败");
        }
        return new RestResult(ResultStatus.OK,"录入成功");
    }

    @PutMapping("/SetUserUpd")
    public RestResult SetUserUpd(@RequestBody User user)
    {
        if (!userService.UserUpd(user))
        {
            return new RestResult(ResultStatus.NG,"更新失败");
        }
        return new RestResult(ResultStatus.OK,"更新成功");
    }

    @DeleteMapping("/SetUserDel")
    public RestResult SetUserDel(@RequestParam("ids")String[] ids)
    {
        if (!userService.UserDel(ids))
        {
            return new RestResult(ResultStatus.NG,"删除失败");
        }
        return new RestResult(ResultStatus.OK,"删除成功");
    }

    @RequestMapping("/testUserAdds")
    public RestResult testUserAdds()
    {
        userService.testUserAdds();
        return new RestResult(ResultStatus.OK,"添加成功");
    }
}
