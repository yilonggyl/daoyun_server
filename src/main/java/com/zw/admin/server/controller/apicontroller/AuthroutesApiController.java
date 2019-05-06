package com.zw.admin.server.controller.apicontroller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zw.admin.server.dao.AuthroutesDao;
import com.zw.admin.server.model.Authroutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

#123456
@RestController
@EnableAutoConfiguration
public class AuthroutesApiController {
    @Autowired
    private AuthroutesDao authroutesDao;

    @RequestMapping("auth_routes")
    JSONObject getAuthRoutesList(){
        JSONObject returnJson = new JSONObject();
        List<Authroutes> jsonList = authroutesDao.getAuthRoutesList();

        for(int i =0 ;i<jsonList.size();i++){

            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = JSONArray.parseArray(jsonList.get(i).getAUTHORS());
            jsonObject.put("authority",jsonArray);
            returnJson.put(jsonList.get(i).getPath(),jsonObject);
        }
        return returnJson;
    }
}
