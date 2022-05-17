package xyz.dongzi.dzchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.dongzi.dzchat.Service.Userservice;
import xyz.dongzi.dzchat.pojo.TbUser;
import xyz.dongzi.dzchat.pojo.vo.Result;
import xyz.dongzi.dzchat.pojo.vo.User;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private Userservice userService;

    @RequestMapping("/login")
    public Result login(@RequestBody TbUser user) {
        //只要产生异常就直接返回登录错误
        try {
            User _user = userService.login(user.getUsername(), user.getPassword());
            if (_user == null) {
                return new Result(false, "登录失败，将检查用户名或者密码是否正确");
            } else {
                return new Result(true, "登录成功", _user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "登录错误");
        }
    }
}
