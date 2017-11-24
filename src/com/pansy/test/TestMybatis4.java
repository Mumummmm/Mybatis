package com.pansy.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pansy.mapper.CategoryMapper;
import com.pansy.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis4 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);

        List<Category> categories = mapper.list();
        for (int i = 0; i < categories.size(); i++) {
            Category c = categories.get(i);
            mapper.delete(c.getId());
        }

        for (int i = 0; i < 30; i++) {
            Category c = new Category();
            c.setName("category " + i);
            mapper.add(c);
        }

        PageHelper.offsetPage(3, 6);
        List<Category> limit = mapper.list();
        for (Category c : limit)
            System.out.println(c);
        PageInfo<Category> pageInfo = new PageInfo<>(limit);
        System.out.println("total" + pageInfo.getTotal());

//        List<Category> categories = mapper.list();
//        for (Category category : categories)
//            mapper.delete(category.getId());
//
//        for (int i = 0; i < 30; i++) {
//            Category c = new Category();
//            c.setName("category " + i);
//            mapper.add(c);
//        }

//        Map<String, Integer> params = new HashMap<>();
//        params.put("start", 3);
//        params.put("count", 3);
//        List<Category> limit = sqlSession.selectList("listCategory", params);
//        for (Category category : limit)
//            System.out.println(category);
    }
}
