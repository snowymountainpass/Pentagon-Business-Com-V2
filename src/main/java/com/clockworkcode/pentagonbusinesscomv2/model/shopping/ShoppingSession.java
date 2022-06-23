package com.clockworkcode.pentagonbusinesscomv2.model.shopping;

import com.clockworkcode.pentagonbusinesscomv2.security.token.LoginToken;
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

@Entity(name = "ShoppingSession")
@Table(name = "shoppingsessions")
public class ShoppingSession {

    @Id
    @SequenceGenerator(name ="shoppingsession_sequence" ,sequenceName ="shoppingsession_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppingsession_sequence")
    private Long shoppingSessionID;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "id")
    private LoginToken loginToken;

    @Column(nullable = false)
    private BigDecimal total;

    private Timestamp createdAt;
    private Timestamp modifiedAt;

    @OneToMany(mappedBy = "shoppingSession",orphanRemoval = true)
    @JsonManagedReference
    private Set<CartItem> cartItems;

    public ShoppingSession(LoginToken loginToken, BigDecimal total, Set<CartItem> cartItems) {
        this.loginToken = loginToken;
        this.total = total;
        this.cartItems = cartItems;
        this.createdAt=new Timestamp(System.currentTimeMillis());
        this.modifiedAt=new Timestamp(System.currentTimeMillis());
    }
}
