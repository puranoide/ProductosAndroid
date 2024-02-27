package com.example.parcial_acosta;

import java.util.UUID;

public class Product {

    private final UUID id;
    private String nameProduct;
    private String brandProduct;
    private String amountProduct;

    public UUID getId() {
        return id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(String amountProduct) {
        this.amountProduct = amountProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrandProduct() {
        return brandProduct;
    }

    public void setBrandProduct(String brandProduct) {
        this.brandProduct = brandProduct;
    }



    public Product() {
        this.id = UUID.randomUUID();
        this.nameProduct = nameProduct;
        this.brandProduct = brandProduct;
        this.amountProduct = amountProduct;
    }
}
