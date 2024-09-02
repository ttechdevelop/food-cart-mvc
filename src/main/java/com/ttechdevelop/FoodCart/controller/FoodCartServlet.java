package com.ttechdevelop.FoodCart.controller;

import com.ttechdevelop.FoodCart.model.dao.FoodCartDbUtil;
import com.ttechdevelop.FoodCart.model.entity.Food;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FoodCartServlet", urlPatterns = "/menu")
public class FoodCartServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the data from the Database (model)
        try {
            List<Food> foodList = FoodCartDbUtil.getFoodList();
            request.setAttribute("foodList", foodList);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


        // redirect to a page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("showFood.jsp");
        dispatcher.forward(request, response);
    }

}