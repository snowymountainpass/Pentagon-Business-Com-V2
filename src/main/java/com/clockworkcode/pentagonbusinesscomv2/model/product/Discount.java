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
@Table(name = "Discounts") //plural !!
public class Discount {


    @Id
    @SequenceGenerator(name ="discount_sequence" ,sequenceName ="discount_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_sequence")
    private Long discountID;

    private String discountName;
    private String discountDescription;
    private BigDecimal discountPercent;
    private Boolean activeDiscount;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;

}
