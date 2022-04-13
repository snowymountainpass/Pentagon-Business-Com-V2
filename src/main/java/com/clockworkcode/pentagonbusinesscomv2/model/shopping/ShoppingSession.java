package com.clockworkcode.pentagonbusinesscomv2.model.shopping;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@Entity(name = "ShoppingSession") //singular !!
@Table(name = "shoppingsessions") //plural !!
public class ShoppingSession {

    @Id
    @SequenceGenerator(name ="shoppingsession_sequence" ,sequenceName ="shoppingsession_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppingsession_sequence")
    private Long shoppingSessionID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "app_userid")
    @JsonBackReference
    private AppUser appUser;

    @Column(nullable = false)
    private BigDecimal total;

//    @Column(nullable = false)
    private Timestamp createdAt;
//    @Column(nullable = false)
    private Timestamp modifiedAt;

    @OneToMany(mappedBy = "shoppingSession")
    @JsonManagedReference
    private Set<CartItem> cartItems;

    public ShoppingSession(AppUser appUser, BigDecimal total, Set<CartItem> cartItems) {
        this.appUser = appUser;
        this.total = total;
        this.cartItems = cartItems;
        this.createdAt=new Timestamp(System.currentTimeMillis());
        this.modifiedAt=new Timestamp(System.currentTimeMillis());
    }
}
