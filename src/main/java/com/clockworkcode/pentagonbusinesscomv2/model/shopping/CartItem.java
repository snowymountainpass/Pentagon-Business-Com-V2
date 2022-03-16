package com.clockworkcode.pentagonbusinesscomv2.model.shopping;

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

@Entity(name = "CartItem") //singular !!
@Table(name = "cartitems") //plural !!
public class CartItem {

    @Id
    @SequenceGenerator(name ="cartitem_sequence" ,sequenceName ="cartitem_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartitem_sequence")
    private Long cartItemID;


    private Long shoppingSessionID;
    private Long productID;

    private Integer quantity;

    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;

}
