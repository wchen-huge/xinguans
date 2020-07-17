package cn.alibab.sys.service;

import cn.alibab.common.model.R;
import cn.alibab.sys.model.SysResources;
import cn.alibab.sys.vo.MenuNodeVo;

import java.util.List;

/**
 * @author wchen
 * @create 2020-06-29 17:31
 */
public interface ResourcesService {
    R getMenu();
    List<MenuNodeVo> getTree(List<SysResources> ress);

    R getAll();
}
