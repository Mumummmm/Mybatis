package com.pansy.test;

import com.pansy.mapper.CategoryMapper;
import com.pansy.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis5 {
    public static void main(String[] args) throws IOException {
        /*
        一级缓存和二级缓存
         */
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        CategoryMapper categoryMapper1 = sqlSession1.getMapper(CategoryMapper.class);
        Category category = categoryMapper.get(1);
        Category category1 = categoryMapper1.get(1);
        System.out.println(category);
        System.out.println(category1);
    }
}
