package com.clockworkcode.pentagonbusinesscomv2.model.shopping;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }) //cascade = CascadeType.ALL
    @JoinColumn(name = "shopping_sessionid")
    @JsonBackReference
    private ShoppingSession shoppingSession;


    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "productid")
    @JsonBackReference
    private Product product;

    private Integer quantity;

//    @Column(nullable = false)
    private Timestamp createdAt;
//    @Column(nullable = false)
    private Timestamp modifiedAt;

    public CartItem(ShoppingSession shoppingSession, Product product, Integer quantity) {
        this.shoppingSession = shoppingSession;
        this.product = product;
        this.quantity = quantity;
        this.createdAt=new Timestamp(System.currentTimeMillis());
        this.modifiedAt=new Timestamp(System.currentTimeMillis());
    }
}
