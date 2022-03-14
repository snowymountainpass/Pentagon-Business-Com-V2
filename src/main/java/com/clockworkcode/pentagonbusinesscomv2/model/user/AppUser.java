package com.clockworkcode.pentagonbusinesscomv2.model.user;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private Long id;

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

}
