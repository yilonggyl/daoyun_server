package com.zw.admin.server.controller.apicontroller;

import com.zw.admin.server.dao.DaoyuncourseDao;
import com.zw.admin.server.model.Daoyuncourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class DaoyuncourseApiController {
    @Autowired
    private DaoyuncourseDao daoyuncourseDao;

    @RequestMapping("daoyuncourse")
    List<Daoyuncourse> daoyuncourseApi(){

        return daoyuncourseDao.getAll();

    }
}
