package cn.junang.sys.vo;

import lombok.Data;

import java.util.List;

/**
 * @author wchen
 * @create 2020-06-29 17:08
 */
@Data
public class MenuNodeVo {
    private Long id;
    private Long pid;
    private String name;
    private String url;
    private String icon;
    private List<MenuNodeVo> children;
}
