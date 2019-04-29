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
import com.zw.admin.server.dao.AuthroutesDao;
import com.zw.admin.server.model.Authroutes;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/authroutess")
public class AuthroutesController {

    @Autowired
    private AuthroutesDao authroutesDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Authroutes save(@RequestBody Authroutes authroutes) {
        authroutesDao.save(authroutes);

        return authroutes;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Authroutes get(@PathVariable Long id) {
        return authroutesDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Authroutes update(@RequestBody Authroutes authroutes) {
        authroutesDao.update(authroutes);

        return authroutes;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return authroutesDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Authroutes> list(PageTableRequest request) {
                return authroutesDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        authroutesDao.delete(id);
    }
}
