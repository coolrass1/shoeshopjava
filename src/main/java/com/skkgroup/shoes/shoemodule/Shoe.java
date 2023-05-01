package com.skkgroup.shoes.shoemodule;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shoe_table")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String shoename;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String imageUrl;

}
