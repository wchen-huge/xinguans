package cn.alibab.sys.service.impl;

import cn.alibab.common.config.excption.ServiceException;
import cn.alibab.common.model.*;
import cn.alibab.common.service.BaseService;
import cn.alibab.common.shiro.JWTToken;
import cn.alibab.common.utils.JWTUtils;
import cn.alibab.common.utils.MD5Utils;
import cn.alibab.sys.mapper.SysUserMapper;
import cn.alibab.sys.model.SysUser;
import cn.alibab.sys.model.SysUserExample;
import cn.alibab.sys.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wchen
 * @create 2020-07-01 9:08
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
    private final SysUserMapper sysUserMapper;

    public UserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public R getUser(String username, PageBean pageBean) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(false);
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        PageHelper.startPage(pageBean.getPage(), pageBean.getSize());
        PageInfo<SysUser> info = new PageInfo<>(sysUserMapper.selectByExample(example));
        return R.ok(new PageResult<SysUser>(info.getTotal(), info.getList()));
    }

    @Override
    public R updateUserState(Long id, Boolean isvalid) {
        SysUser user = new SysUser();
        user.setId(id);
        user.setIsvaild(isvalid);
        sysUserMapper.updateByPrimaryKeySelective(user);
        return R.ok();
    }

    @Override
    public R delUserById(Long userId) {
        SysUser user = new SysUser();
        user.setId(userId);
        user.setIsdel(true);
        sysUserMapper.updateByPrimaryKeySelective(user);
        return R.ok();
    }

    @Override
    public R addUser(SysUser sysUser) {
        if (isUserExit(sysUser.getUsername())) {
            return R.error(RCode.USER_NAME_REPEAT);
        }
        sysUser.setIsvaild(true);
        sysUser.setPassword(Constant.PWD);
        sysUserMapper.insertSelective(sysUser);
        return R.ok();
    }

    @Override
    public R editUser(SysUser sysUser) {
        SysUser sysUser1 = sysUserMapper.selectByPrimaryKey(sysUser.getId());
        if (!(sysUser1.getUsername().equals(sysUser.getUsername()))) {
            if (isUserExit(sysUser.getUsername())) {
                return R.error(RCode.USER_NAME_REPEAT);
            }

        }
        sysUser.setPassword(null);
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
        return R.ok();
    }

    //登录方法
    @Override
    public R userLogin(String username, String password) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andIsdelEqualTo(false).andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
//        for (SysUser sysUser : sysUsers) {
//            System.out.println(sysUser);
//        }
        if (sysUsers == null || sysUsers.size() < 1) {
            throw new ServiceException(RCode.USER_NAME_PASSWORD);
        }
        SysUser user = sysUsers.get(0);
        String salt = user.getSalt();
        String target = MD5Utils.md5Encryption(password, salt);
        //生成Token
        String token = JWTUtils.sign(username, target);
        JWTToken jwtToken = new JWTToken(token);
        try {
            SecurityUtils.getSubject().login(jwtToken);
        } catch (AuthenticationException e) {
            throw new ServiceException(RCode.TOKENERROR);
        }
        return R.ok(token);
    }

    @Override
    public R info() {
        return R.ok(getUser());
    }


    private Boolean isUserExit(String username) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andIsdelEqualTo(false).andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if (sysUsers != null && sysUsers.size() > 0) {
            return true;
        }
        return false;
    }
}
