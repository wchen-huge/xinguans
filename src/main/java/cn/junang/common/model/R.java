package cn.junang.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wchen
 * @create 2020-06-29 16:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private Integer code;
    private String msg;
    private Object data;
    public static R ok(RCode rCode,Object data){
        return new R(rCode.getCode(),rCode.getMsg(),data);

    }
    public static R ok(RCode rCode){
        return  R.ok(rCode,null);

    }
    public static R ok(Object data){
        return  R.ok(RCode.SUCCESS,data);

    }
    public static R ok(){
        return  R.ok(RCode.SUCCESS);

    }
    public static R error(RCode rCode){
        return  new R(rCode.getCode(),rCode.getMsg(),null);

    }
    public static R error(){
        return   R.error(RCode.ERROR);

    }

}
