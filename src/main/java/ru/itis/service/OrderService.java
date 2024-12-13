package ru.itis.service;

import ru.itis.model.Order;
import ru.itis.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private final OrderRepository repository;

    public OrderService() {
        repository = new OrderRepository();
    }
    public List<Order> findAll() {
        return repository.findAll();
    }
    public Order findById(Long id) {return repository.findById(id);}

}
