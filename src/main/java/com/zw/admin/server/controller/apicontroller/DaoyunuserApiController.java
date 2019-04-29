package com.zw.admin.server.controller.apicontroller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zw.admin.server.dao.DaoyunuserDao;
import com.zw.admin.server.model.Daoyunuser;
import com.zw.admin.server.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class DaoyunuserApiController {

    @Autowired
    private DaoyunuserDao daoyunuserDao;


    @RequestMapping("login/account")
    JSONObject daoyunuserlogin(@RequestBody LoginModel loginModel){

        String daoyunuser =  daoyunuserDao.getByLogin(loginModel);
        if (daoyunuser==null)
        {
            return JSONObject.parseObject("{\"status\":\"error\"}");
        }
        else
        {
            String str = "{\"status\":\"ok\",\"type\":\"account\",\"currentAuthority\":\""+daoyunuser+"\"}";
            return JSONObject.parseObject(str);
        }

    }

    @RequestMapping("currentUser/{name}")
    String daoyunuserlogin(@PathVariable String name){


        String str1 = "{\"province\":{\"label\":\"浙江省\",\"key\":\"330000\"},\"city\":{\"label\":\"杭州市\",\"key\":\"330100\"}}";
        String str2 = "[{\"key\":\"0\",\"label\":\"很有想法的\"},{\"key\":\"1\",\"label\":\"专注设计\"},{\"key\":\"2\",\"label\":\"辣~\"}]";

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(JSONObject.parse("{\"key\":\"0\",\"label\":\"很有想法的\"}"));
        jsonArray.add(JSONObject.parse("{\"key\":\"1\",\"label\":\"专注设计\"}"));
        jsonArray.add(JSONObject.parse("{\"key\":\"2\",\"label\":\"辣~\"}"));
        JSONObject json1 = JSONObject.parseObject(str1);
        JSONObject userJson = daoyunuserDao.getCurrentUser(name);

        userJson.put("geographic",json1);
        userJson.put("tags",jsonArray);

        return JSONObject.toJSONString(userJson);

    }

    @RequestMapping("userlist")
    String daoyunuserlist(){

        List<JSONObject> jsonList = daoyunuserDao.getUerList();
        for(int i=0 ;i<jsonList.size();i++){
            String str1 = "{\"province\":{\"label\":\"浙江省\",\"key\":\"330000\"},\"city\":{\"label\":\"杭州市\",\"key\":\"330100\"}}";

            JSONArray jsonArray = new JSONArray();
            jsonArray.add(JSONObject.parse("{\"key\":\"0\",\"label\":\"很有想法的\"}"));
            jsonArray.add(JSONObject.parse("{\"key\":\"1\",\"label\":\"专注设计\"}"));
            jsonArray.add(JSONObject.parse("{\"key\":\"2\",\"label\":\"辣~\"}"));
            JSONObject json1 = JSONObject.parseObject(str1);
            jsonList.get(i).put("geographic",json1);
            jsonList.get(i).put("tags",jsonArray);
        }
        return  JSONObject.toJSONString(jsonList);
    }

    @RequestMapping("resetPassword/{id}")
    Daoyunuser resetPassword(@PathVariable Long id){

        daoyunuserDao.resetPassword(Long.valueOf(id));
        return daoyunuserDao.getById(Long.valueOf(id));
    }

}
