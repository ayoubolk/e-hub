package com.ehub.controllers;

import com.ehub.entities.OrderLines;
import com.ehub.services.OrderLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ismail on 30/01/2016.
 */
@RestController
public class OrderLinesController {
    private OrderLinesService orderLinesService;

    @Autowired
    public void setOrderLinesService(OrderLinesService orderLinesService) {
        this.orderLinesService = orderLinesService;
    }

    @RequestMapping(value = "/orderLines",method = RequestMethod.GET)
    public Iterable listOrderLines(){
       return orderLinesService.findAll();
    }

    @RequestMapping(value="/orderLine/{id}",method = RequestMethod.GET)
    public OrderLines getOrderLineById(@PathVariable String id){
        return orderLinesService.findById(id);
    }
    @RequestMapping(value = "/orderLine",method = RequestMethod.POST)
    public OrderLines insertOrderLines(@RequestBody OrderLines orderLines){
        return orderLinesService.insert(orderLines);
    }
    @RequestMapping(value = "/orderLine",method = RequestMethod.PUT)
    public OrderLines updateOrderLines(@RequestBody OrderLines orderLines){
        return orderLinesService.update(orderLines);
    }
    @RequestMapping(value="/orderLine/{id}",method = RequestMethod.DELETE)
    public Long gdeleteOrderLinesById(@PathVariable String id){
        return orderLinesService.deleteById(id);
    }
}
