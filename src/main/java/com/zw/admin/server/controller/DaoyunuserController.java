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
import com.zw.admin.server.dao.DaoyunuserDao;
import com.zw.admin.server.model.Daoyunuser;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/daoyunusers")
public class DaoyunuserController {

    @Autowired
    private DaoyunuserDao daoyunuserDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Daoyunuser save(@RequestBody Daoyunuser daoyunuser) {
        daoyunuserDao.save(daoyunuser);

        return daoyunuser;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Daoyunuser get(@PathVariable Long id) {
        return daoyunuserDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Daoyunuser update(@RequestBody Daoyunuser daoyunuser) {
        daoyunuserDao.update(daoyunuser);

        return daoyunuser;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return daoyunuserDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Daoyunuser> list(PageTableRequest request) {
                return daoyunuserDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        daoyunuserDao.delete(id);
    }
}
