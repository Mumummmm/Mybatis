package com.pansy.test;

import com.pansy.mapper.CategoryMapper;
import com.pansy.mapper.OrderMapper;
import com.pansy.mapper.ProductMapper;
import com.pansy.pojo.Category;
import com.pansy.pojo.Order;
import com.pansy.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis3 {
    public static void main(String[] args) throws IOException {
        //annotation way
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        //add
//        Category category = new Category();
//        category.setName("new category");
//        mapper.add(category);

        //delete
//        mapper.delete(3);

        //get
//        Category category = mapper.get(2);
//        System.out.println(category);

        //update
//        Category category = new Category();
//        category.setName("new category");
//        mapper.add(category);
//        Category c = mapper.get(4);
//        c.setName("update category");
//        mapper.update(c);

        //list
//        List<Category> categories = mapper.list();
//        for (Category category : categories)
//            System.out.println(category);

        //one to more
//        List<Category> categories = mapper.list();
//        for (Category category : categories)
//            System.out.println(category);

        //more to one
//        List<Product> products = productMapper.list();
//        for (Product product : products)
//            System.out.println(product);

        //more to more
//        List<Order> orders = orderMapper.list();
//        for (Order order : orders)
//            System.out.println(order);

        //dynamic sql
        System.out.println(selectPersonSql());

        sqlSession.commit();
        sqlSession.close();
    }

    private static String selectPersonSql() {
        return new SQL() {{
            SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
            SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
            FROM("PERSON P");
            FROM("ACCOUNT A");
            INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
            INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
            WHERE("P.ID = A.ID");
            WHERE("P.FIRST_NAME like ?");
            OR();
            WHERE("P.LAST_NAME like ?");
            GROUP_BY("P.ID");
            HAVING("P.LAST_NAME like ?");
            OR();
            HAVING("P.FIRST_NAME like ?");
            ORDER_BY("P.ID");
            ORDER_BY("P.FULL_NAME");
        }}.toString();
    }
}
