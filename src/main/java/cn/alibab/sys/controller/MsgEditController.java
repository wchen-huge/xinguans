package cn.alibab.sys.controller;

import cn.alibab.common.model.R;
import cn.alibab.sys.model.MsgInfo;
import cn.alibab.sys.service.MsgEditService;

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
