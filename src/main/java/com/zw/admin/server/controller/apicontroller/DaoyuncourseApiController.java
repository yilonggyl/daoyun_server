package com.zw.admin.server.controller.apicontroller;

import com.zw.admin.server.dao.DaoyuncourseDao;
import com.zw.admin.server.model.Daoyuncourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class DaoyuncourseApiController {
    @Autowired
    private DaoyuncourseDao daoyuncourseDao;

    @RequestMapping("courselist")
    List<Daoyuncourse> daoyuncourseApi(){

        return daoyuncourseDao.getAll();

    }
}
