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

@Entity(name = "AppUserPayment")
@Table(name = "app_user_payments")
public class AppUserPayment {

    @Id
    @SequenceGenerator(name ="appuserpayment_sequence" ,sequenceName ="appuserpayment_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuserpayment_sequence")
    private Long id;

    @Column(nullable = false,columnDefinition = "text")
    private String paymentType;
    @Column(nullable = false,columnDefinition = "text")
    private String provider;
    @Column(nullable = false,columnDefinition = "text")
    private String accountNumber;
    @Column(nullable = false)
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "app_userID",nullable = false)
    private AppUser appUser;
}
