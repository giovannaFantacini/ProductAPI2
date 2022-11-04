package com.Product.ProductAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable{

    @Id
    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String image;

    public Product() {
    }

    public Product(final String designation) {
        setDesignation(designation);
    }

    private Product(final String sku, final String designation  ) {
        setSku(sku);
        setDesignation(designation);
    }
    public Product(final String sku, final String designation, final String description, final String image) {
        this(sku, designation);

        setDescription(description);
        setImage(image);
    }


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        if (sku.length()!=12 || !sku.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("'SKU' has not a correct format");
        }
        this.sku = sku;
    }
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        if (designation == null || designation.isEmpty()) {
            throw new IllegalArgumentException("'Designation' is a mandatory attribute of Product");
        }
        if (designation.length()>50){
            throw new IllegalArgumentException("'Designation' has a maximum of 50 characters");
        }
        if (designation.trim().length() == 0){
            throw new IllegalArgumentException("'Designation' cannot have only white spaces");
        }

        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("'Description' is a mandatory attribute of Product");
        }

        if (description.length()>1024){
            throw new IllegalArgumentException("'Description' has a maximum of 1024 characters");
        }
        if (description.trim().length() == 0){
            throw new IllegalArgumentException("'Description' cannot have only white spaces");
        }

        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
