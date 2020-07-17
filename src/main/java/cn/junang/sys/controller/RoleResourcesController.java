package cn.junang.sys.controller;

import cn.junang.common.model.R;
import cn.junang.sys.model.SysRoleResources;
import cn.junang.sys.service.RoleResourcesService;
import org.springframework.web.bind.annotation.*;

/**
 * @author wchen
 * @create 2020-07-06 9:29
 */
@RestController
@RequestMapping("sys/roleRes")
public class RoleResourcesController {
    private final RoleResourcesService roleResourcesService;

    public RoleResourcesController(RoleResourcesService roleResourcesService) {
        this.roleResourcesService = roleResourcesService;
    }

    @DeleteMapping("/{roleId}/{resIds}")
    public R delete(@PathVariable("roleId") Long roleId,@PathVariable("resIds") String resIds) {
        return roleResourcesService.delete(roleId, resIds);
    }
    @PutMapping("/{roleId}")
    public R update(@PathVariable("roleId") Long roleId,@RequestBody SysRoleResources[] roleRes){
        return roleResourcesService.update(roleId,roleRes);
    }

}
