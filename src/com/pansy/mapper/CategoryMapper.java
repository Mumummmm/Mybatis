package com.pansy.mapper;

import com.pansy.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CategoryMapper {

    @Insert("insert into category_(name) values(#{name})")
    int add(Category category);
    @Delete("delete from category_ where id = #{id}")
    void delete(int id);
    @Select("select * from category_ where id = #{id}")
    Category get(int id);
    @Update("update category_ set name = #{name} where id = #{id}")
    void update(Category category);
    @Select("select * from category_")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "com.pansy.mapper.ProductMapper.listByCategory"))
    })
    List<Category> list();

    @Select("select * from category_ limit #{start}, #{count}")
    List<Category> listByPage(@Param("start") int start, @Param("count") int count);
}
