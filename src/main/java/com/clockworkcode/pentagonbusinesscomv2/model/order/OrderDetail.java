package com.clockworkcode.pentagonbusinesscomv2.model.order;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "OrderDetail") //singular !!
@Table(name = "orderdetails") //plural !!
public class OrderDetail {

    @Id
    @SequenceGenerator(name ="orderdetail_sequence" ,sequenceName ="orderdetail_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderdetail_sequence")
    private Long orderDetailID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="app_userid")
    private AppUser appUser;

    @OneToMany(mappedBy = "orderDetail")
    private Set<OrderItem> orderItems;

    private BigDecimal total;
    private Long paymentID;

    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;

}
