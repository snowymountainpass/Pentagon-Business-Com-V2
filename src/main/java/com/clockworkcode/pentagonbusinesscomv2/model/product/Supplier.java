package com.clockworkcode.pentagonbusinesscomv2.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Supplier") //singular !!
@Table(name = "Suppliers") //plural !!
public class Supplier {

    @Id
    @SequenceGenerator(name ="supplier_sequence" ,sequenceName ="supplier_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_sequence")
    private Long supplierID;

    private String companyName;
    private String contactFirstName;
    private String contactLastName;
    private String contactTitle;
    private String supplierAddressLine1;
    private String supplierAddressLine2;
    private String supplierCity;
    private String supplierCounty;
    private String supplierPostalCode;
    private String supplierCountry;
    private String supplierTelephone;
    private String supplierMobile;
    private String supplierEmail;
    private String supplierURL;
    private Long discountID;
    private String notesOnSupplier;

}
