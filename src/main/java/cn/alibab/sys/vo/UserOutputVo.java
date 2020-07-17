package cn.alibab.sys.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author wchen
 * @create 2020-07-01 10:01
 */
@Data
public class UserOutputVo {
    private Long id;

    private String username;

    private String email;

    private String avatar;

    private String phone;

    private Boolean isvaild;

    private Integer sex;

    private Date birth;

    private Long departmentId;

    private String remark;




}
