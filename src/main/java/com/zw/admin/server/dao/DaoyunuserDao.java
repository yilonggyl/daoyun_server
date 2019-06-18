package com.zw.admin.server.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.zw.admin.server.model.LoginModel;
import org.apache.ibatis.annotations.*;

import com.zw.admin.server.model.Daoyunuser;

@Mapper
public interface DaoyunuserDao {

    @Select("select * from daoyunuser t where t.id = #{id}")
    Daoyunuser getById(Long id);

    @Delete("delete from daoyunuser where id = #{id}")
    int delete(Long id);

    int update(Daoyunuser daoyunuser);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into daoyunuser(name, avatar, userid, email, signature, title, `group`, tags, notifyCount, unreadCount, country, geographic, address, phone, password, role_id, status) values(#{name}, #{avatar}, #{userid}, #{email}, #{signature}, #{title}, #{group}, #{tags}, #{notifyCount}, #{unreadCount}, #{country}, #{geographic}, #{address}, #{phone}, #{password}, #{roleId}, #{status})")
    int save(Daoyunuser daoyunuser);
    
    int count(@Param("params") Map<String, Object> params);

    List<Daoyunuser> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
	
	@Select("SELECT t.`password`,t.role_id,t.address,t.avatar,t.country,t.email,t.geographic,t.`group`,t.`name`,t.notifyCount,t.phone,t.signature,t.tags,t.title,t.unreadCount,t.userid from daoyunuser as t")
    List<Daoyunuser> getAll();



    @Select("SELECT c.`uniqeKey` from daoyunuser as t JOIN daoyunrole as c WHERE t.role_id=c.id AND t.`name`=#{userName} AND t.`password`=#{password}")
    String getByLogin(LoginModel loginModel);

    @Select("SELECT t.address,t.avatar,t.country,t.email,t.`group`,t.id,t.`name`,t.notifyCount,t.`password`,t.phone,t.role_id,t.signature,t.`status`,t.title,t.unreadCount,t.userid FROM daoyunuser as t  WHERE t.`name`=#{name}")
    JSONObject getCurrentUser(String name);

    @Select("SELECT t.address,t.avatar,t.country,t.email,t.`group`,t.id,t.`name`,t.notifyCount,t.`password`,t.phone,t.role_id,t.signature,t.`status`,t.title,t.unreadCount,t.userid FROM daoyunuser as t ")
    List<JSONObject> getUerList();

    @Update("UPDATE daoyunuser SET `password`='123456' WHERE id=#{id}")
    void resetPassword(Long id);

}
