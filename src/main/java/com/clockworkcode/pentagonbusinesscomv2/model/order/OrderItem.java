package com.clockworkcode.pentagonbusinesscomv2.model.order;

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

@Entity(name = "OrderItem") //singular !!
@Table(name = "orderitems") //plural !!
public class OrderItem {

    @Id
    @SequenceGenerator(name ="orderitem_sequence" ,sequenceName ="orderitem_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitem_sequence")
    private Long orderItemID;

    @ManyToOne
    @JoinColumn(name = "order_detailid",nullable = false)
    private OrderDetail orderDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_itemid")
    private Product product;

    private Integer quantity;

    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;
}
