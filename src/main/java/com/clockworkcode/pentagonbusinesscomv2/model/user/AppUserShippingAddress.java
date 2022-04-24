package com.clockworkcode.pentagonbusinesscomv2.model.user;

import javax.persistence.*;

@Entity(name = "AppUserShippingAddress") //singular !!
@Table(name = "app_user_shipping_addresses") //plural !!
public class AppUserShippingAddress {

    @Id
    @SequenceGenerator(name ="appusershippingaddress_sequence" ,sequenceName ="appusershippingaddress_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appusershippingaddress_sequence")
    private Long appUserShippingAddressID;

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
    @JoinColumn(name="app_userID",nullable = false) //O
    private AppUser appUser; //X   //Y- appUserID

    public AppUserShippingAddress(String shippingAddress, String shippingCity, String shippingCounty, String shippingPostalCode, String shippingCountry, AppUser appUser) {
        this.shippingAddress = shippingAddress;
        this.shippingCity = shippingCity;
        this.shippingCounty = shippingCounty;
        this.shippingPostalCode = shippingPostalCode;
        this.shippingCountry = shippingCountry;
        this.appUser = appUser;
    }

    public AppUserShippingAddress() {

    }
}
