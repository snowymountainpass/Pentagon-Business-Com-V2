package com.clockworkcode.pentagonbusinesscomv2.model.shopping;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_sessionid")
    private ShoppingSession shoppingSession;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productid")
    private Product product;

    private Integer quantity;

    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;

}
