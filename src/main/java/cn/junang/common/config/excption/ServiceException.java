package cn.junang.common.config.excption;

import cn.junang.common.model.RCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wchen
 * @create 2020-07-14 14:44
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceException extends RuntimeException{
    private RCode rCode;
}
