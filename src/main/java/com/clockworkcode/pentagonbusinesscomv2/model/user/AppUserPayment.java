package com.clockworkcode.pentagonbusinesscomv2.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "AppUserPayment") //singular !!
@Table(name = "AppUserPayments") //plural !!
public class AppUserPayment {

    @Id
    @SequenceGenerator(name ="appuserpayment_sequence" ,sequenceName ="appuserpayment_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuserpayment_sequence")
    private Long id;

    private Long appUserID; // ONE TO MANY => One user can have many payments && Many PAYMENTS can belong to one user

    @Column(nullable = false,columnDefinition = "text")
    private String paymentType;
    @Column(nullable = false,columnDefinition = "text")
    private String provider;
    @Column(nullable = false,columnDefinition = "text")
    private String accountNumber;
    @Column(nullable = false)
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "appUserID",nullable = false)
    private AppUser appUser;
}
