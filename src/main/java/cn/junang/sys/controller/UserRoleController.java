package cn.junang.sys.controller;

import cn.junang.common.model.R;
import cn.junang.sys.service.UserRoleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wchen
 * @create 2020-07-03 10:29
 */
@RestController
@RequestMapping("sys/userRole")
public class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
    @PutMapping("/{userId}/{roleIds}")
    public R assignRole(@PathVariable("userId") Long userId,@PathVariable("roleIds") String roleIds){
        return userRoleService.assignRole(userId,roleIds);
    }
}
