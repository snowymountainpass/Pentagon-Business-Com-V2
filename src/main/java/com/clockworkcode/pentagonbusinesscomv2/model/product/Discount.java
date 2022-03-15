package com.clockworkcode.pentagonbusinesscomv2.model.product;

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

@Entity(name = "Discount") //singular !!
@Table(name = "discounts") //plural !!
public class Discount {


    @Id
    @SequenceGenerator(name ="discount_sequence" ,sequenceName ="discount_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_sequence")
    private Long discountID;

    @Column(nullable = false,columnDefinition = "text")
    private String discountName;
    @Column(nullable = false,columnDefinition = "text")
    private String discountDescription;
    @Column(nullable = false)
    private BigDecimal discountPercent;
    @Column(nullable = false)
    private Boolean activeDiscount;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;
    @Column(nullable = false)
    private Timestamp deletedAt;


    @ManyToOne
    @JoinColumn(name = "supplierid", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "productid",nullable = false)
    private Product product;

}
