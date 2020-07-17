package cn.alibab.sys.service;

import cn.alibab.common.model.PageBean;
import cn.alibab.common.model.R;

/**
 * @author wchen
 * @create 2020-07-03 8:51
 */
public interface RoleService {
    R assignRoles(String userId);

    R roles(String roleName, PageBean pageBean);
}
