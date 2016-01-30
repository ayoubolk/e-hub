package com.ehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ehub.entities.Category;
import com.ehub.entities.Order;
import com.ehub.services.OrderService;

@RestController
public class OrderController {
	private OrderService orderService;
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
    public Iterable listOrders(){
	return orderService.findAll();
	}
	@RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order insertOrder(@RequestBody Order order){
	return orderService.insert(order);
	}
	@RequestMapping(value = "/order", method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody Order order){
	return orderService.update(order);
	}
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable String id){
	return orderService.findById(id);
	}
	@RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public Long deleteOrderById(@PathVariable String id){
	return orderService.deleteById(id);
	}
}
