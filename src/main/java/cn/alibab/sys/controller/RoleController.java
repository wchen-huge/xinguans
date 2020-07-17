package cn.alibab.sys.controller;

import cn.alibab.common.model.PageBean;
import cn.alibab.common.model.R;
import cn.alibab.sys.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wchen
 * @create 2020-07-03 8:53
 */
@RestController
@RequestMapping("sys/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {

        this.roleService = roleService;
    }

    @GetMapping("/{userId}")
    public R assignRoles(@PathVariable("userId") String userId) {
        return roleService.assignRoles(userId);
    }

    @GetMapping
    public R roles(String roleName, PageBean pageBean) {
        return roleService.roles(roleName,pageBean);
    }
}
