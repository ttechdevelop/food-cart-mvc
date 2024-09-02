package com.ttechdevelop.FoodCart.model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.ttechdevelop.FoodCart.model.entity.Food;

public class FoodCartDbUtil {

    public static List<Food> getFoodList() throws IOException, ClassNotFoundException, SQLException {

        Properties props = new Properties();
        InputStream in = FoodCartDbUtil.class.getClassLoader().getResourceAsStream("config.properties");
        props.load(in);
        in.close();

        String url = props.getProperty("db.url");
        String userName = props.getProperty("db.username");
        String password = props.getProperty("db.password");

        List<Food> food = new ArrayList<Food>();

        // load mysql driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // get connection
        Connection connection = DriverManager.getConnection(url, userName, password);

        // create statement
        Statement statement = connection.createStatement();

        // execute the statement and loop over the result set
        ResultSet resultSet = statement.executeQuery("SELECT * FROM dish_menu");

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String item = resultSet.getString(2);
            BigDecimal price = resultSet.getBigDecimal(3);

            Food foodObj = new Food(id, item, price);
            food.add(foodObj);
        }

        return food;
    }
}
