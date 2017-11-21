package com.pansy.test;

import com.pansy.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatisd2 {
    public static void main(String[] args) throws IOException {
        //day 2
        //dynamic sql, example: if, where, choose, foreach, bind
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlsession = sqlSessionFactory.openSession();

        //find all product
//        List<Product> products = sqlsession.selectList("listProduct2");
//        for (Product product : products) {
//            System.out.println(product);
//        }

        //find some product with limit
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "a");
//        List<Product> products = sqlsession.selectList("listProduct2", map);
//        for (Product product : products) {
//            System.out.println(product);
//        }

        //find some product with limits
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "a");
////        map.put("price", "89");
//        List<Product> products = sqlsession.selectList("listProduct3", map);
//        for (Product product : products) {
//            System.out.println(product);
//        }

        //update(set label)
        Product product = new Product();
        product.setId(6);
        product.setName("product z");
        product.setPrice(88.99f);
        sqlsession.update("updateProduct2", product);

        //choose label
//        Map<String, Object> params = new HashMap<>();
//        List<Product> products = sqlsession.selectList("listProduct4", params);
//        for (Product product : products) {
//            System.out.println(product);
//        }

        //foreach label
//        List<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(3);
//        ids.add(5);
//        List<Product> products = sqlsession.selectList("listProduct5", ids);
//        for (Product product : products) {
//            System.out.println(product);
//        }

        //bind label
//        Map<String, String> params = new HashMap<>();
//        params.put("name", "product");
//        List<Product> products = sqlsession.selectList("listProduct6", params);
//        for (Product product : products)
//            System.out.println(product);

        sqlsession.commit();
        sqlsession.close();
    }
}
