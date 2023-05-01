package com.skkgroup.shoes.shoemodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    Orderservice orderservice;
    @Autowired
    Order_itemService orderItemService;
    @PostMapping("/place")
    String Placeorder(@RequestBody Order order){
        System.out.println(String.valueOf(order));


       return  orderservice.placeOrder(order);


    }

    @PostMapping("/createitem")
    Order_item createOrderItem (@RequestBody Order_item item){



        return  orderItemService.createOrderItem(item);


    }


    @GetMapping("/list")
    List <Order> getAll(){
        return orderservice.getAllOrders();
    }
}
