package cn.alibab.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;


/**
 * @Author zhangyukang
 * @Date 2020/3/1 12:33
 * @Version 1.0
 **/
public class MD5Utils {

    /**
     * 密码加密
     * @return
     */
    public static String md5Encryption(String source,String salt){
        String algorithmName = "MD5";//加密算法
        int hashIterations = 1024;//加密次数
        SimpleHash simpleHash = new SimpleHash(algorithmName,source,salt,hashIterations);
        return simpleHash+"";
    }

    public static void main(String[] args) {
        String admin = JWTUtils.sign("admin", "123456");
        System.out.println(admin);
//        System.out.println(md5Encryption("123456","1"));
    }
}
