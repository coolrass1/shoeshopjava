package com.skkgroup.shoes.shoemodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Orderservice {
    @Autowired
    private OrderJPA orderJPA;

    String placeOrder(Order or){
        System.out.println(String.valueOf(or));
        var placedorder= orderJPA.save(or);

        return"order succesfully placed";
    }
    List <Order> getAllOrders(){
        return orderJPA.findAll();
    }


}
