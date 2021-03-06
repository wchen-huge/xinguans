package cn.junang.sys.dao;

import cn.junang.sys.model.SysRoleResources;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * @author wchen
 * @create 2020-07-06 9:44
 */
public interface RoleResourcesDao {
    @Delete("delete from sys_role_resources where role_id=#{roleId} and res_id in(${resIds})")
    Integer delete(@Param("roleId") Long roleId, @Param("resIds") String resIds);

    Integer insert(SysRoleResources[] roleRes);

    @Delete("delete from sys_role_resources where role_id=#{roleId}")
    Integer deleteAll(@Param("roleId") Long roleId);
}
