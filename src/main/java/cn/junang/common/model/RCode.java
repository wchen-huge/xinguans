package cn.junang.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author wchen
 * @create 2020-06-29 16:39
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum RCode {
    SUCCESS(200,"操作成功"),
    ERROR(400,"操作失败！"),
    TOKENERROR(4001,"token认证错误"),
    USER_NAME_PASSWORD(4003,"用户名或密码错误"),
    TOKENFITRR(4002,"token无效，您无权访问该接口"),
    REPEAT_KEY(4005,"数据库已存在该记录"),
    NO_FOUND(4004,"路径不存在"),
    AUTHER_ERROR(4006,"没有权限，请联系管理员授权"),
    USER_NAME_REPEAT(500,"用户名已存在，请重新输入！");
    private Integer code;
    private String msg;
}
