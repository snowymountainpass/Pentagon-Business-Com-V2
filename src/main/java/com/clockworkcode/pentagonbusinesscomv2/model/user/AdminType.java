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

@Entity(name = "AdminType") //singular !!
@Table(name = "AdminTypes") //plural !!
public class AdminType {

    @Id
    @SequenceGenerator(name ="admintype_sequence" ,sequenceName ="admintype_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admintype_sequence")
    private Long id;

    @Column(nullable = false,columnDefinition = "text")
    private String adminType;
    @Column(nullable = false,columnDefinition = "text")
    private String permissions;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;

}