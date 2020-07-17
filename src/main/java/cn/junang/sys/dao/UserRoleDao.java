package cn.junang.sys.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author wchen
 * @create 2020-07-03 10:48
 */
public interface UserRoleDao {
    @Insert("insert into sys_user_role (user_id,role_id) select #{userId},id from sys_role where id in(${roleIds})")
    Integer insert(@Param("userId") Long userId,@Param("roleIds") String roleIds);
}
