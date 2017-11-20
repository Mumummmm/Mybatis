package com.pansy.test;

import com.pansy.pojo.Category;
import com.pansy.pojo.Order;
import com.pansy.pojo.OrderItem;
import com.pansy.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession s = sqlSessionFactory.openSession();

//        Category c = new Category();
//        c.setName("new Category");
//        int i = s.insert("addCategory", c);
//        c.setId(6);
//        list(s);

        //delete
//        s.delete("deleteCategory", c);
//        list(s);

        //get
//        Category c = s.selectOne("getCategory", 3);
//        System.out.println(c.getName());

        //update
//        Category c = new Category();
//        c.setName("updated Category");
//        c.setId(3);
//        s.update("updateCategory", c);

        //fuzzy search by name
//        List<Category> cs = s.selectList("listCategoryByName", "cat");
//        for (Category c : cs) {
//            System.out.println(c);
//        }
        //fuzzy search by name and by id
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", 3);
//        params.put("name", "cat");
//        List<Category> cs = s.selectList("listCategoryByIdAndName", params);
//        for (Category c : cs) {
//            System.out.println(c);
//        }

        //select all the product in a category
//        List<Category> cs = s.selectList("listCategory");
//        for (Category c : cs) {
//            System.out.println(c);
//        }

        //select all the product which contains category
//        List<Product> products = s.selectList("listProduct");
//        for (Product p : products) {
//            System.out.println(p);
//        }

        //update product's category
//        Product p = new Product();
//        p.setId(5);
//        Category c = new Category();
//        c.setId(1);
//        p.setCategory(c);
//        s.update("updateProduct", p);

        //list all the Order
//        List<Order> orders = s.selectList("listOrder");
//        for (Order o : orders) {
//            System.out.println(o);
//        }

        //add an OrderItem
//        Order o1 = s.selectOne("getOrder", 1);
//        Product p6 = s.selectOne("getProduct", 6);
//        OrderItem orderItem = new OrderItem();
//        orderItem.setOrder(o1);
//        orderItem.setProduct(p6);
//        orderItem.setNumber(200);
//        s.insert("addOrderItem", orderItem);

        //delete an OrderItem
//        OrderItem orderItem = new OrderItem();
//        orderItem.setId(8);
//        s.delete("deleteOrderItem", orderItem);

        //delete Order
        s.delete("deleteOrder", 1);

        s.commit();
        s.close();
    }

    public static void list(SqlSession s) {
        List<Category> cs = s.selectList("listCategory");
        for (Category category : cs) {
            System.out.println(category);
        }
        System.out.println();
    }
}
