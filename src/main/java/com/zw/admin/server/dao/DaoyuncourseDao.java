package com.zw.admin.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zw.admin.server.model.Daoyuncourse;

@Mapper
public interface DaoyuncourseDao {

    @Select("select * from daoyuncourse t where t.id = #{id}")
    Daoyuncourse getById(Long id);

    @Delete("delete from daoyuncourse where id = #{id}")
    int delete(Long id);

    int update(Daoyuncourse daoyuncourse);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into daoyuncourse(coursename, teachername, time, intro, info) values(#{coursename}, #{teachername}, #{time}, #{intro}, #{info})")
    int save(Daoyuncourse daoyuncourse);
    
    int count(@Param("params") Map<String, Object> params);

    List<Daoyuncourse> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from daoyuncourse")
    List<Daoyuncourse> getAll();
}
