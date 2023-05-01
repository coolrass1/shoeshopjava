package com.skkgroup.shoes.shoemodule;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Entity
@Table(name = "orders")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String customerAddress;

    @OneToMany(cascade = CascadeType.PERSIST
    )
    @JoinColumn(
            name = "Orderdetail_Id",
            referencedColumnName = "id"
    )
    private List<Order_item> orderDetails;

    private Long total;

    // getters and setters
}