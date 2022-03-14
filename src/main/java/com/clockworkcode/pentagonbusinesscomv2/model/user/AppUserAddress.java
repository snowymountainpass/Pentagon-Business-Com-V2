package com.clockworkcode.pentagonbusinesscomv2.model.user;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "AppUserAddress") //singular !!
@Table(name = "AppUserAddresses") //plural !!
public class AppUserAddress {

    @Id
    @SequenceGenerator(name ="appuseraddress_sequence" ,sequenceName ="appuseraddress_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuseraddress_sequence")
    private Long appUserAddressID;

    @Column(nullable = false,columnDefinition = "text")
    private String addressLine1;
    @Column(nullable = false,columnDefinition = "text")
    private String addressLine2;
    @Column(nullable = false,columnDefinition = "text")
    private String city;
    @Column(nullable = false,columnDefinition = "text")
    private String county;
    @Column(nullable = false,columnDefinition = "text")
    private String country;
    @Column(nullable = false,columnDefinition = "text")
    private String telephone;
    @Column(nullable = false,columnDefinition = "text")
    private String mobilePhone;
    @Column(nullable = false,columnDefinition = "text")
    private String billingAddress;
    @Column(nullable = false,columnDefinition = "text")
    private String billingCity;
    @Column(nullable = false,columnDefinition = "text")
    private String billingCounty;
    @Column(nullable = false,columnDefinition = "text")
    private String billingPostalCode;
    @Column(nullable = false,columnDefinition = "text")
    private String billingCountry;
    @Column(nullable = false,columnDefinition = "text")
    private String shippingAddress;
    @Column(nullable = false,columnDefinition = "text")
    private String shippingCity;
    @Column(nullable = false,columnDefinition = "text")
    private String shippingCounty;
    @Column(nullable = false,columnDefinition = "text")
    private String shippingPostalCode;
    @Column(nullable = false,columnDefinition = "text")
    private String shippingCountry;

    // ONE TO MANY => One user can have many addresses && one address can belong to many users
    @ManyToOne
    @JoinColumn(name="appUserID",nullable = false) //O
    private AppUser appUser; //X   //Y- appUserID

}