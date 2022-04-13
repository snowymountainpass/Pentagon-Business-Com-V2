package com.clockworkcode.pentagonbusinesscomv2.security.token;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class LoginToken {

    @SequenceGenerator(name="login_token_sequence",sequenceName = "login_token_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="login_token_sequence" )
    @Id
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    @ManyToOne
    @JoinColumn(nullable = false,name = "app_userid")
    @JsonBackReference
    private AppUser appUser;

    public LoginToken(
            String token,
            LocalDateTime createdAt,
            LocalDateTime expiredAt,
            AppUser appUser
    )
    {
        this.token=token;
        this.createdAt=createdAt;
        this.expiresAt=expiredAt;
        this.appUser=appUser;
    }

}
