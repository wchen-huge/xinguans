package cn.alibab.sys.service;

import cn.alibab.common.model.R;
import cn.alibab.sys.model.MsgInfo;

/**
 * @author wchen
 * @create 2020-07-09 17:57
 */
public interface MsgEditService {
    R getMsgData();

    R editMsgFrom(MsgInfo msgInfo);

}
