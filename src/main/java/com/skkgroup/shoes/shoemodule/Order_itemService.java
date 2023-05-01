package com.skkgroup.shoes.shoemodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class Order_itemService {
    @Autowired
    private Order_itemJPA orderItemJPA;

     Order_item createOrderItem(Order_item oitem){
         return orderItemJPA.save(oitem);
       //
    }
}
