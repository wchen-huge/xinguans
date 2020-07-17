package cn.junang.sys.controller;

import cn.junang.common.model.PageBean;
import cn.junang.common.model.R;
import cn.junang.sys.model.SysUser;
import cn.junang.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

/**
 * @author wchen
 * @create 2020-07-01 9:10
 */
@RestController
@RequestMapping("sys/user")
@Api(tags = "用户管理")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation("获取所有用户")
    @RequiresPermissions("sys:user:getAll")
    public R getUser(String username, PageBean pageBean){
        return userService.getUser(username,pageBean);

    }
    @PutMapping("/{id}/{isvalid}")
    public R updateUserState(@PathVariable("id") Long id, @PathVariable("isvalid") Boolean isvalid){
        return userService.updateUserState(id,isvalid);

    }
    @DeleteMapping("/{userId}")
    public R delUserById(@PathVariable("userId") Long userId){
        return userService.delUserById(userId);
    }
    @PostMapping
    public R addUser(@RequestBody SysUser sysUser){
        return userService.addUser(sysUser);
    }
    @PutMapping
    public R editUser(@RequestBody SysUser sysUser){
        return userService.editUser(sysUser);
    }
    @PostMapping("login")
    public R userLogin(String username, String password){
        return userService.userLogin(username,password);
    }
    @GetMapping("info")
    public R info(){
        return userService.info();
    }
}
