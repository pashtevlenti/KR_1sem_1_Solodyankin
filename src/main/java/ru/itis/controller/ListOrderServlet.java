package ru.itis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.service.OrderService;

import java.io.IOException;

@WebServlet("/list_order")
public class ListOrderServlet extends HttpServlet {

    private final OrderService service = new OrderService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("orders",service.findAll());
            request.getRequestDispatcher("list_order.ftl").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
