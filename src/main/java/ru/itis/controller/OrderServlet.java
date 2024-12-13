package ru.itis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.service.OrderService;

import java.io.IOException;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private final OrderService service = new OrderService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        try {
            Long id = Long.valueOf(request.getParameter("id"));

            request.setAttribute("order", service.findById(id));
            request.getRequestDispatcher("order.ftl").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
