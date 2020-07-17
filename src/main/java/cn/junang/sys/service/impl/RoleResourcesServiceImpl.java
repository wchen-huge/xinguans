package cn.junang.sys.service.impl;

import cn.junang.common.model.R;
import cn.junang.common.service.BaseService;
import cn.junang.sys.dao.RoleResourcesDao;
import cn.junang.sys.mapper.SysRoleResourcesMapper;
import cn.junang.sys.model.SysRoleResources;
import cn.junang.sys.model.SysRoleResourcesExample;
import cn.junang.sys.service.RoleResourcesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wchen
 * @create 2020-07-06 9:28
 */
@Service
public class RoleResourcesServiceImpl extends BaseService implements RoleResourcesService {
    private final SysRoleResourcesMapper sysRoleResourcesMapper;
    private final RoleResourcesDao roleResourcesDao;

    public RoleResourcesServiceImpl(SysRoleResourcesMapper sysRoleResourcesMapper, RoleResourcesDao roleResourcesDao) {
        this.sysRoleResourcesMapper = sysRoleResourcesMapper;
        this.roleResourcesDao = roleResourcesDao;
    }


    @Override
    public R delete(Long roleId, String resIds) {
        roleResourcesDao.delete(roleId, resIds);
        return R.ok();
    }

    @Transactional
    @Override
    public R update(Long roleId, SysRoleResources[] roleRes) {
        SysRoleResourcesExample example = new SysRoleResourcesExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        sysRoleResourcesMapper.deleteByExample(example);
        if (roleRes!=null&&roleRes.length>0){
            roleResourcesDao.insert(roleRes);
        }
        return R.ok();
    }
}
