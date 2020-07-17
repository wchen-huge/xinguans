package cn.junang.sys.service;

import cn.junang.common.model.R;
import cn.junang.sys.model.SysResources;
import cn.junang.sys.vo.MenuNodeVo;

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
