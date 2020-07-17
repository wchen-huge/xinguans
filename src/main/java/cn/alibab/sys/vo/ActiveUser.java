package cn.alibab.sys.vo;

import cn.alibab.sys.model.SysRole;
import cn.alibab.sys.model.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author wchen
 * @create 2020-07-10 15:09
 */
@Data
public class ActiveUser {
    private List<SysRole> roles;
    private SysUser user;
    private List<String> permissions;
}
