package com.clockworkcode.pentagonbusinesscomv2.model.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "ProductInventory") //singular !!
@Table(name = "product_inventories") //plural !!
public class ProductInventory {

    @Id
    @SequenceGenerator(name ="productinventory_sequence" ,sequenceName ="productinventory_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productinventory_sequence")
    private Long productInventoryID;

    @Column(nullable = false,columnDefinition = "integer")
    private Integer quantity;
//    @Column(nullable = false)
//    private Timestamp createdAt;
//    @Column(nullable = false)
//    private Timestamp modifiedAt;
//    @Column(nullable = false)
//    private Timestamp deletedAt;

    @OneToOne(mappedBy = "productInventory")
    private Product product;

}
