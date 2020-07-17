package cn.alibab.sys.service.impl;

import cn.alibab.common.model.R;
import cn.alibab.sys.mapper.MsgInfoMapper;
import cn.alibab.sys.model.MsgInfo;
import cn.alibab.sys.service.MsgEditService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wchen
 * @create 2020-07-09 18:04
 */
@Service
public class MsgEditServiceImpl implements MsgEditService {
    private final MsgInfoMapper msgInfoMapper;

    public MsgEditServiceImpl(MsgInfoMapper msgInfoMapper) {
        this.msgInfoMapper = msgInfoMapper;
    }

    @Override
    public R getMsgData() {
        List<MsgInfo> msgInfo = msgInfoMapper.selectByExample(null);
        return R.ok(msgInfo);
    }

    @Override
    public R editMsgFrom(MsgInfo msgInfo) {
        msgInfoMapper.selectByPrimaryKey(msgInfo.getId());
        msgInfoMapper.updateByPrimaryKeySelective(msgInfo);
        return R.ok();
    }
}

