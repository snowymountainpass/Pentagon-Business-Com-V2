package com.clockworkcode.pentagonbusinesscomv2.model.user;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "AppUserAddress") //singular !!
@Table(name = "app_user_addresses") //plural !!
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
    private String postalCode;



    // ONE TO MANY => One user can have many addresses && one address can belong to many users
    @ManyToOne
    @JoinColumn(name="app_userID",nullable = false) //O
    private AppUser appUser; //X   //Y- appUserID

    public AppUserAddress(String addressLine1, String addressLine2, String city, String county, String country, String telephone,String postalCode, AppUser appUser) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.county = county;
        this.country = country;
        this.telephone = telephone;
        this.appUser = appUser;
        this.postalCode=postalCode;
    }
}
