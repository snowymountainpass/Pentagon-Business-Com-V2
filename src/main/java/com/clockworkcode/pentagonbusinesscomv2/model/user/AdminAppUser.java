package com.clockworkcode.pentagonbusinesscomv2.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "AdminAppUser") //singular !!
@Table(name = "admin_app_users") //plural !!
public class AdminAppUser {

    @Id
    @SequenceGenerator(name ="adminappuser_sequence" ,sequenceName ="adminappuser_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminappuser_sequence")
    private Long adminAppUserID;

    @Column(nullable = false,columnDefinition = "text")
    private String username;
    @Column(nullable = false,columnDefinition = "text")
    private String password;
    @Column(nullable = false,columnDefinition = "text")
    private String first_name;
    @Column(nullable = false,columnDefinition = "text")
    private String last_name;
    @Column(nullable = false,columnDefinition = "integer")
    private Integer typeID;

    @Column(nullable = false)
    private Timestamp lastLogin;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "admin_typeID", referencedColumnName ="admin_typeID" )
//    private AdminType adminType;




    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_typeid")
    private AdminType adminType;

}
