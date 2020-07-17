package cn.alibab.sys.service.impl;

import cn.alibab.common.model.PageBean;
import cn.alibab.common.model.PageResult;
import cn.alibab.common.model.R;
import cn.alibab.common.service.BaseService;
import cn.alibab.sys.dao.ResourcesDao;
import cn.alibab.sys.dao.RoleDao;
import cn.alibab.sys.mapper.SysRoleMapper;
import cn.alibab.sys.model.SysResources;
import cn.alibab.sys.model.SysRole;
import cn.alibab.sys.model.SysRoleExample;
import cn.alibab.sys.service.ResourcesService;
import cn.alibab.sys.service.RoleService;
import cn.alibab.sys.vo.MenuNodeVo;
import cn.alibab.sys.vo.RoleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wchen
 * @create 2020-07-03 8:51
 */
@Service
public class RoleServiceImpl extends BaseService implements RoleService {
    private final SysRoleMapper sysRoleMapper;
    private final RoleDao roleDao;
    private final ResourcesDao resourcesDao;
    private final ResourcesService resourcesService;
    public RoleServiceImpl(SysRoleMapper sysRoleMapper, RoleDao roleDao, ResourcesDao resourcesDao, ResourcesService resourcesService) {
        this.sysRoleMapper = sysRoleMapper;
        this.roleDao = roleDao;
        this.resourcesDao = resourcesDao;
        this.resourcesService = resourcesService;
    }

    @Override
    public R assignRoles(String userId) {
        List<Map<String, Object>> allRole = roleDao.getAllRole();
        List<Long> roleIds = roleDao.getRoleIdsByUserId(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("roles",allRole);
        map.put("roleIds",roleIds);
        return R.ok(map);
    }

    @Override
    public R roles(String roleName, PageBean pageBean) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(false);
        if (!StringUtils.isEmpty(roleName)){
            criteria.andNameLike("%"+roleName+"%");
        }
        PageHelper.startPage(pageBean.getPage(),pageBean.getSize());
        PageInfo<SysRole> info = new PageInfo<>(sysRoleMapper.selectByExample(example));
        ArrayList<RoleVo> roleVos = new ArrayList<>();
        info.getList().forEach(role ->{
            List<SysResources> ress = resourcesDao.getResByRoleId(role.getId());
            List<MenuNodeVo> tree = resourcesService.getTree(ress);
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(role,roleVo);
            roleVo.setChildren(tree);
            roleVos.add(roleVo);
        });
        return R.ok(new PageResult<>(info.getTotal(),roleVos));
    }
}
