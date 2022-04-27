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

@Entity(name = "PaymentDetail")
@Table(name = "paymentdetails")
public class PaymentDetail {

    @Id
    @SequenceGenerator(name ="paymentdetail_sequence" ,sequenceName ="paymentdetail_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentdetail_sequence")
    private Long paymentDetailID;

    @Column(nullable = false)
    private BigDecimal paymentAmount;
    @Column(nullable = false)
    private String provider;
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;


    @OneToOne(mappedBy = "paymentDetail")
    private OrderDetail orderDetail ;

}
