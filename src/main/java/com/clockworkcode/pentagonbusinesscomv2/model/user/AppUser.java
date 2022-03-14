package com.clockworkcode.pentagonbusinesscomv2.model.user;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "AppUser") //singular !!
@Table(name = "AppUsers") //plural !!
public class AppUser {

    @Id
    @SequenceGenerator(name ="appuser_sequence" ,sequenceName ="appuser_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_sequence")
    private Long appUserID;



    @Column(nullable = false,columnDefinition = "text")
    private String username;
    @Column(nullable = false,columnDefinition = "text")
    private String password;
    @Column(nullable = false,columnDefinition = "text")
    private String firstName;
    @Column(nullable = false,columnDefinition = "text")
    private String lastName;
    @Column(nullable = false,columnDefinition = "text")
    private String telephone;
    @Column(nullable = false,columnDefinition = "text",unique = false)
    private String email;
    @Column(nullable = false)
    private Timestamp createAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;

    @OneToMany(mappedBy = "appUser") //X
    private List<AppUserAddress> appUserAddresses; //O

}
