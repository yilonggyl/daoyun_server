package com.zw.admin.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zw.admin.server.model.Daoyunrole;

@Mapper
public interface DaoyunroleDao {

    @Select("select * from daoyunrole t where t.id = #{id}")
    Daoyunrole getById(Long id);

    @Delete("delete from daoyunrole where id = #{id}")
    int delete(Long id);

    int update(Daoyunrole daoyunrole);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into daoyunrole(note, uniqeKey, name, status) values(#{note}, #{uniqeKey}, #{name}, #{status})")
    int save(Daoyunrole daoyunrole);
    
    int count(@Param("params") Map<String, Object> params);

    List<Daoyunrole> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from daoyunrole")
    List<Daoyunrole> getAll();
}
