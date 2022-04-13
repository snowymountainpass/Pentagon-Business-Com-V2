package com.clockworkcode.pentagonbusinesscomv2.security.token;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @SequenceGenerator(name="confirmation_token_sequence",sequenceName = "confirmation_token_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="confirmation_token_sequence" )
    @Id
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(name = "app_userid",nullable = false)
    private AppUser appUser;


    public ConfirmationToken(
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
