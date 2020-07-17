package cn.alibab.sys.service;

import cn.alibab.common.model.R;
import cn.alibab.sys.model.SysRoleResources;

/**
 * @author wchen
 * @create 2020-07-06 9:27
 */
public interface RoleResourcesService {
    R delete(Long roleId, String resIds);

    R update(Long roleId, SysRoleResources[] roleRes);
}
