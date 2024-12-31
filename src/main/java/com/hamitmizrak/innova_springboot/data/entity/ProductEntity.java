package com.hamitmizrak.innova_springboot.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// LOMBOK
@Getter
@Setter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder

// Entity
@Entity(name = "Products")
@Table(name = "products")

//  Product(M)- Order(N)
public class ProductEntity extends BaseEntity {

    // FIELD
    // NAME
    private String name;

    // TRADE
    private String trade;

    // NOTES
    private String notes;

    ////////////////////////////////////////////////////////////////////////////
    // RELATION
    // COMPOSITION

    // Product(M) - Order(N)
    @ManyToMany(mappedBy = "productsOrdersEntity")
    private List<OrderEntity> ordersProductsEntity;

} //end CustomerEntity