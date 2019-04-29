package com.zw.admin.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zw.admin.server.model.Authroutes;

@Mapper
public interface AuthroutesDao {

    @Select("select * from authroutes t where t.id = #{id}")
    Authroutes getById(Long id);

    @Delete("delete from authroutes where id = #{id}")
    int delete(Long id);

    int update(Authroutes authroutes);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into authroutes(name, path, AUTHORS, pid) values(#{name}, #{path}, #{AUTHORS}, #{pid})")
    int save(Authroutes authroutes);
    
    int count(@Param("params") Map<String, Object> params);

    List<Authroutes> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("SELECT * FROM `authroutes`")
    List<Authroutes> getAuthRoutesList();
}
