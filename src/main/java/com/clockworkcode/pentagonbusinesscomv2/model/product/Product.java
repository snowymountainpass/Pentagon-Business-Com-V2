package com.clockworkcode.pentagonbusinesscomv2.model.product;

import com.clockworkcode.pentagonbusinesscomv2.model.Base;
import com.clockworkcode.pentagonbusinesscomv2.model.order.OrderItem;
import com.clockworkcode.pentagonbusinesscomv2.model.shopping.CartItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Product") //singular !!
@Table(name = "products") //plural !!
public class Product extends Base {

    @Id
    @SequenceGenerator(name ="product_sequence" ,sequenceName ="product_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long productID;

    @Column(nullable = false,columnDefinition = "text")
    private String productName;
    @Column(nullable = false,columnDefinition = "text")
    private String productDescription;
    @Column(nullable = false,columnDefinition = "text")
    private String productSKU;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ProductBrand productBrand;

    //prod cat
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ProductCategory productCategory;

    @Column(nullable = false)
    private Integer productInventory;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_supplier",
            joinColumns = {@JoinColumn(name = "productid")},
            inverseJoinColumns = {@JoinColumn(name = "supplierid")}
    )
    private Set<Supplier> suppliers = new HashSet<>(); // A product can have many suppliers && a supplier can have many products

    @Column(nullable = false)
    private Integer productPrice;

    @OneToMany(mappedBy = "product")
    private Set<Discount> discounts;

    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;
    @Column(nullable = false)
    private Timestamp deletedAt;

    @OneToOne(mappedBy = "product", orphanRemoval = true)
    private OrderItem orderItem;

    @OneToOne(mappedBy = "product")
    @JsonManagedReference
    private CartItem cartItem;
    // TODO: TRY ONE-TO-MANY
    // TODO: TRY MANY-TO-MANY


    @Column(nullable = false, columnDefinition = "integer")
    private Integer rating;

    @Column(nullable = false, columnDefinition = "integer")
    private Float deliveryCost;

    @Column(nullable = false,columnDefinition = "text")
    private String img;

    public Product(String productName, String productDescription, String productSKU, ProductBrand productBrand, ProductCategory productCategory, Integer productInventory, Integer productPrice, Integer rating, String img) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productSKU = productSKU;
        this.productBrand = productBrand;
        this.productCategory = productCategory;
        this.productInventory = productInventory;
        this.productPrice = productPrice;
        this.rating = rating;
        this.deliveryCost = calculateDeliveryCost();
        this.img = img;
        this.createdAt=new Timestamp(System.currentTimeMillis());
        this.modifiedAt=new Timestamp(System.currentTimeMillis());
        this.deletedAt=new Timestamp(System.currentTimeMillis());
    }

    public Float calculateDeliveryCost() {
       return  (float) ((productPrice * 15) / 100);
    }
}
