package cn.junang.sys.service.impl;

import cn.junang.common.model.Constant;
import cn.junang.common.model.R;
import cn.junang.common.service.BaseService;
import cn.junang.sys.dao.ResourcesDao;
import cn.junang.sys.mapper.SysResourcesMapper;
import cn.junang.sys.model.SysResources;
import cn.junang.sys.service.ResourcesService;
import cn.junang.sys.vo.MenuNodeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author wchen
 * @create 2020-06-29 17:32
 */
@Service
public class ResourcesServiceImpl extends BaseService implements ResourcesService {
    private final ResourcesDao resourcesDao;
    private final SysResourcesMapper sysResourcesMapper;

    public ResourcesServiceImpl(ResourcesDao resourcesDao, SysResourcesMapper sysResourcesMapper) {
        this.resourcesDao = resourcesDao;
        this.sysResourcesMapper = sysResourcesMapper;
    }


    @Override
    public R getMenu() {
        List<SysResources> ress = resourcesDao.getMenu(getUserId());
        List<MenuNodeVo> menus = new ArrayList<>();
        createMenu(ress, menus, Constant.PID);
        return R.ok(menus);
    }

    @Override
    public List<MenuNodeVo> getTree(List<SysResources> ress) {
        List<MenuNodeVo> menus = new ArrayList<>();
        createMenu(ress, menus, Constant.PID);
        return menus;
    }

    @Override
    public R getAll() {
        List<SysResources> ress = sysResourcesMapper.selectByExample(null);
        List<MenuNodeVo> menus = new ArrayList<>();
        createMenu(ress, menus, Constant.PID);
        return R.ok(menus);
    }

    protected void createMenu(List<SysResources> ress, List<MenuNodeVo> menus, Long pid) {
        ress.forEach(res -> {
            //=-1 代表根节点
            if (res.getPid().equals(pid)) {
                MenuNodeVo node = new MenuNodeVo();
                BeanUtils.copyProperties(res, node);
                node.setChildren(new ArrayList<>());
                createMenu(ress, node.getChildren(), res.getId());
                menus.add(node);
            }
        });
    }
}
