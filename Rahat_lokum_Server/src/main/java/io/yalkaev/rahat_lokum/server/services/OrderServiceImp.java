package io.yalkaev.rahat_lokum.server.services;

import io.yalkaev.rahat_lokum.server.entity.Order;
import io.yalkaev.rahat_lokum.server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository repository;

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order getByID(long id) {
        return repository.findOne(id);
    }

    public Order save(Order order) {
        return repository.saveAndFlush(order);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
