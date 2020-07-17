package cn.alibab.sys.dao;

import cn.alibab.sys.model.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author wchen
 * @create 2020-07-03 9:07
 */
public interface RoleDao {
    @Select("select id 'key',name 'label' from sys_role where isdel=0")
    List<Map<String,Object>> getAllRole();
    @Select("select role_id from sys_user_role where user_id=#{userId}")
    List<Long> getRoleIdsByUserId(@Param("userId") String userId);
    @Select("SELECT * FROM sys_role WHERE id IN (SELECT role_id FROM sys_user_role WHERE user_id =#{userId})")
    List<SysRole> getRoleByUserId(@Param("userId") Long userId);
}
