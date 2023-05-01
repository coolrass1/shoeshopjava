package com.skkgroup.shoes.shoemodule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderJPA extends JpaRepository<Order,Long> {
}
