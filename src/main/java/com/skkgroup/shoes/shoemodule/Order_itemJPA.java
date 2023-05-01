package com.skkgroup.shoes.shoemodule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_itemJPA extends JpaRepository<Order_item, Long> {
}
