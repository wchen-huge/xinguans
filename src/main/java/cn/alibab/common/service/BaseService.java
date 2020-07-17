package cn.alibab.common.service;

import cn.alibab.sys.vo.ActiveUser;
import org.apache.shiro.SecurityUtils;

/**
 * @author wchen
 * @create 2020-06-29 17:05
 */
public abstract class BaseService {
    public Long getUserId() {
        ActiveUser user = getUser();
        return user.getUser().getId();
    }

    public ActiveUser getUser() {
        return (ActiveUser) SecurityUtils.getSubject().getPrincipal();
    }
}
