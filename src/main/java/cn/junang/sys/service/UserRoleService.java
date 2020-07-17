package cn.junang.sys.service;

import cn.junang.common.model.R;

/**
 * @author wchen
 * @create 2020-07-03 10:28
 */
public interface UserRoleService {
    R assignRole(Long userId, String roleIds);
}
