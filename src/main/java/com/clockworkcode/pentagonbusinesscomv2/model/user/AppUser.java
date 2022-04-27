package com.clockworkcode.pentagonbusinesscomv2.model.user;

import com.clockworkcode.pentagonbusinesscomv2.model.order.OrderDetail;
import com.clockworkcode.pentagonbusinesscomv2.model.shopping.ShoppingSession;
import com.clockworkcode.pentagonbusinesscomv2.security.token.ConfirmationToken;
import com.clockworkcode.pentagonbusinesscomv2.security.token.LoginToken;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "AppUser")
@Table(name = "app_users")
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(name ="appuser_sequence" ,sequenceName ="appuser_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_sequence")
    private Long appUserID;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;

    @OneToMany(mappedBy = "appUser")
    private List<AppUserAddress> appUserAddresses;

    @OneToMany(mappedBy = "appUser")
    private List<AppUserShippingAddress> appUserShippingAddresses;

    @OneToMany(mappedBy = "appUser")
    private List<AppUserPayment> appUserPayments;

    @OneToMany(mappedBy = "appUser",orphanRemoval = true)
    @JsonManagedReference
    private List<ConfirmationToken> confirmationTokens;

    @OneToMany(mappedBy = "appUser",orphanRemoval = true)
    @JsonManagedReference
    private List<LoginToken> loginTokens;

    @OneToOne(mappedBy = "appUser")
    private OrderDetail orderDetail;

    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    private Boolean locked = false;
    private Boolean enabled= false;


    public AppUser(String email,String password) {
        this.email = email;
        this.password = password;
        this.appUserRole = AppUserRole.USER;
    }

    public AppUser(String password, String firstName, String lastName, String email, AppUserRole appUserRole) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.appUserRole = appUserRole;
    }

    public AppUser(String username, String password, String firstName, String lastName, String telephone, String email, List<AppUserAddress> appUserAddresses, List<AppUserPayment> appUserPayments, OrderDetail orderDetail) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.appUserAddresses = appUserAddresses;
        this.appUserPayments = appUserPayments;
        this.orderDetail = orderDetail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());

        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
