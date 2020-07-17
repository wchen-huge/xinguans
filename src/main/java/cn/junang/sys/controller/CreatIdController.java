package cn.junang.sys.controller;

import cn.junang.sys.dao.CreateId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wchen
 * @create 2020-07-16 16:37
 */
@RestController
public class CreatIdController {
    private CreateId createId;

    public CreatIdController(CreateId createId) {
        this.createId = createId;
    }
    @GetMapping("id")
    public Object test(){
       return createId.getId(1);
    }
}
