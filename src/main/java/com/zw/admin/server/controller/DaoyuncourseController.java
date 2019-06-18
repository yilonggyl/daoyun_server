package com.zw.admin.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zw.admin.server.page.table.PageTableRequest;
import com.zw.admin.server.page.table.PageTableHandler;
import com.zw.admin.server.page.table.PageTableResponse;
import com.zw.admin.server.page.table.PageTableHandler.CountHandler;
import com.zw.admin.server.page.table.PageTableHandler.ListHandler;
import com.zw.admin.server.dao.DaoyuncourseDao;
import com.zw.admin.server.model.Daoyuncourse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/daoyuncourses")
public class DaoyuncourseController {

    @Autowired
    private DaoyuncourseDao daoyuncourseDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Daoyuncourse save(@RequestBody Daoyuncourse daoyuncourse) {
        daoyuncourseDao.save(daoyuncourse);

        return daoyuncourse;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Daoyuncourse get(@PathVariable Long id) {
        return daoyuncourseDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Daoyuncourse update(@RequestBody Daoyuncourse daoyuncourse) {
        daoyuncourseDao.update(daoyuncourse);

        return daoyuncourse;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return daoyuncourseDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Daoyuncourse> list(PageTableRequest request) {
                return daoyuncourseDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        daoyuncourseDao.delete(id);
    }
}
