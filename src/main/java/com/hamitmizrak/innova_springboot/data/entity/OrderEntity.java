package com.hamitmizrak.innova_springboot.data.entity;

import com.hamitmizrak.innova_springboot.business.dto.CustomerDto;
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
@Entity(name = "Orders")
@Table(name = "orders")

//  Order(N) - Customer(1)
//  Order(N) - Product(M)
public class OrderEntity extends BaseEntity {

    // FIELD
    // NAME
    private String name;

    // PRICE
    private String price;

    // NOTES
    private String notes;

    ////////////////////////////////////////////////////////////////////////////
    // RELATION
    // COMPOSITION

    // Order(N) - Customer(1)
    // Order(1) - Customer(1) NOT: Customer bilgilerine Order üzerinden erişimden sağlayacağım.
    // Bundan dolayı @JoinColumn Order içinde yazıyoruz
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id",unique = true)
    private CustomerEntity customerOrderEntity;

    // Order(N) - Product(M)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_product",
            joinColumns =@JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<ProductEntity> productsOrdersEntity; //NOT: ProductEntity içinde mappedBy ekle => productsOrdersEntity

    // Customer(1) - Order(N)
} //end CustomerEntity
