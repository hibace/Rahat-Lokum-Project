package io.yalkaev.rahat_lokum.server.controller;

import io.yalkaev.rahat_lokum.server.entity.Order;
import io.yalkaev.rahat_lokum.server.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getAllOrders() {
        return service.getAll();
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order getOrder(@PathVariable("id") long orderID) {
        return service.getByID(orderID);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    @ResponseBody
    public Order saveOrder(@RequestBody Order order) {
        return service.save(order);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }
}
