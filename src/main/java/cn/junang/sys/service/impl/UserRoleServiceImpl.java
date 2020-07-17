package cn.junang.sys.service.impl;

import cn.junang.common.model.R;
import cn.junang.common.service.BaseService;
import cn.junang.sys.dao.UserRoleDao;
import cn.junang.sys.mapper.SysUserRoleMapper;
import cn.junang.sys.model.SysUserRoleExample;
import cn.junang.sys.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author wchen
 * @create 2020-07-03 10:29
 */
@Service
public class UserRoleServiceImpl extends BaseService implements UserRoleService {
    private final SysUserRoleMapper sysUserRoleMapper;
    private final UserRoleDao userRoleDao;

    public UserRoleServiceImpl(SysUserRoleMapper sysUserRoleMapper, UserRoleDao userRoleDao) {
        this.sysUserRoleMapper = sysUserRoleMapper;
        this.userRoleDao = userRoleDao;
    }

    @Transactional
    @Override
    public R assignRole(Long userId, String roleIds) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        sysUserRoleMapper.deleteByExample(example);
        if (!StringUtils.isEmpty(roleIds)){
            if (roleIds.equals("aa")){
                sysUserRoleMapper.deleteByExample(example);
                return R.ok();
            }
            userRoleDao.insert(userId,roleIds);
        }
        return R.ok();
    }
}
