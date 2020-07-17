package cn.junang.common.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author wchen
 * @create 2020-07-10 14:11
 */
public class JWTToken implements AuthenticationToken {
    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
