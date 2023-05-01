package com.skkgroup.shoes.shoemodule;

import jakarta.persistence.*;
import lombok.*;

@Entity


@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order_item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //private Long shoeid;
    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "shoe_id",
            referencedColumnName = "id"
    )
    private Shoe shoe;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private double qty;
}
