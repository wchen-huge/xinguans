package cn.junang.sys.controller;

import cn.junang.common.model.R;
import cn.junang.sys.model.MsgInfo;
import cn.junang.sys.service.MsgEditService;

import org.springframework.web.bind.annotation.*;


/**
 * @author wchen
 * @create 2020-07-09 17:52
 */
@RestController
@RequestMapping("sys/msg")
public class MsgEditController {
    private final MsgEditService msgEditService;

    public MsgEditController(MsgEditService msgEditService) {
        this.msgEditService = msgEditService;
    }
    @GetMapping
    public R getMsgData(){
        return msgEditService.getMsgData();
    }
   @PutMapping
    public R editMsgFrom(@RequestBody MsgInfo msgInfo){
        return msgEditService.editMsgFrom(msgInfo);
   }
}
