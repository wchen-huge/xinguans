package cn.junang.sys.service;

import cn.junang.common.model.PageBean;
import cn.junang.common.model.R;
import cn.junang.sys.model.SysUser;

/**
 * @author wchen
 * @create 2020-07-01 9:08
 */
public interface UserService {
    R getUser(String username, PageBean pageBean);

    R updateUserState(Long id, Boolean isvalid);

    R delUserById(Long userId);

    R addUser(SysUser sysUser);

    R editUser(SysUser sysUser);

    R userLogin(String username, String password);

    R info();
}
