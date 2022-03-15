package com.clockworkcode.pentagonbusinesscomv2.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "OrderDetail") //singular !!
@Table(name = "orderdetails") //plural !!
public class OrderDetails {

    @Id
    @SequenceGenerator(name ="orderdetail_sequence" ,sequenceName ="orderdetail_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderdetail_sequence")
    private Long orderdetailID;

    private Long appUserID;
    private BigDecimal total;
    private Long paymentID;

    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;

}
