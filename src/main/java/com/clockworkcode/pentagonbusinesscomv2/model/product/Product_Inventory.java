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
@Table(name = "ProductInventories") //plural !!
public class Product_Inventory {

    @Id
    @SequenceGenerator(name ="productinventory_sequence" ,sequenceName ="productinventory_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productinventory_sequence")
    private Long productInventoryID;

    private Integer quantity;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;

}
