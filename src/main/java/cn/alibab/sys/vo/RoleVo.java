package cn.alibab.sys.vo;

import cn.alibab.sys.model.SysRole;
import lombok.Data;

import java.util.List;

/**
 * @author wchen
 * @create 2020-07-03 11:43
 */
@Data
public class RoleVo extends SysRole {
    List<MenuNodeVo> children;
}
