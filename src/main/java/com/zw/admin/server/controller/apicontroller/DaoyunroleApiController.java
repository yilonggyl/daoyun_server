package com.zw.admin.server.controller.apicontroller;

import com.alibaba.fastjson.JSONObject;
import com.zw.admin.server.dao.DaoyunroleDao;
import com.zw.admin.server.model.Daoyunrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DaoyunroleApiController {

    @Autowired
    private DaoyunroleDao daoyunroleDao;

    @RequestMapping("rolelist")
    List<Daoyunrole> daoyunuserlist(){

        return  daoyunroleDao.getAll();
    }

}
