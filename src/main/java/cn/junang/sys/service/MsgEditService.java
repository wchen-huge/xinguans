package cn.junang.sys.service;

import cn.junang.common.model.R;
import cn.junang.sys.model.MsgInfo;

/**
 * @author wchen
 * @create 2020-07-09 17:57
 */
public interface MsgEditService {
    R getMsgData();

    R editMsgFrom(MsgInfo msgInfo);

}
