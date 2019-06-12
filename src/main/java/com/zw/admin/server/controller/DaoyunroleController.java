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
import com.zw.admin.server.dao.DaoyunroleDao;
import com.zw.admin.server.model.Daoyunrole;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/daoyunroles")
public class DaoyunroleController {

    @Autowired
    private DaoyunroleDao daoyunroleDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Daoyunrole save(@RequestBody Daoyunrole daoyunrole) {
        daoyunroleDao.save(daoyunrole);

        return daoyunrole;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Daoyunrole get(@PathVariable Long id) {
        return daoyunroleDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Daoyunrole update(@RequestBody Daoyunrole daoyunrole) {
        daoyunroleDao.update(daoyunrole);

        return daoyunrole;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return daoyunroleDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Daoyunrole> list(PageTableRequest request) {
                return daoyunroleDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        daoyunroleDao.delete(id);
    }
}
