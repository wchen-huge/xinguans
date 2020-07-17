package cn.alibab.sys.dao;

import cn.alibab.sys.model.SysResources;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wchen
 * @create 2020-06-29 17:26
 */
public interface ResourcesDao {
    @Select("select * from sys_resources where ismenu =1 and id in( select res_id from sys_role_resources where role_id in ( select role_id from sys_user_role where user_id=#{userId}));")
    List<SysResources> getMenu(@Param("userId") Long userId);

    @Select("select * from sys_resources where id in (select res_id from sys_role_resources where role_id=#{roleId})")
    List<SysResources> getResByRoleId(@Param("roleId") Long roleId);
    @Select("select perms from sys_resources where perms is not null and id in( select res_id from sys_role_resources where role_id in ( select role_id from sys_user_role where user_id=#{userId}));")
    List<String> getPriam(@Param("userId") Long userId);
}
