package com.clockworkcode.pentagonbusinesscomv2.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Supplier")
@Table(name = "suppliers")
public class Supplier {

    @Id
    @SequenceGenerator(name ="supplier_sequence" ,sequenceName ="supplier_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_sequence")
    private Long supplierID;

    @Column(nullable = false,columnDefinition = "text")
    private String companyName;
    @Column(nullable = false,columnDefinition = "text")
    private String contactFirstName;
    @Column(nullable = false,columnDefinition = "text")
    private String contactLastName;
    @Column(nullable = false,columnDefinition = "text")
    private String contactTitle;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierAddressLine1;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierAddressLine2;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierCity;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierCounty;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierPostalCode;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierCountry;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierTelephone;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierMobile;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierEmail;
    @Column(nullable = false,columnDefinition = "text")
    private String supplierURL;
    @Column(nullable = false,columnDefinition = "text")

    @OneToMany(mappedBy = "supplier")
    private Set<Discount> discounts;

    @Column(nullable = false,columnDefinition = "text")
    private String notesOnSupplier;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Product> products;

}
