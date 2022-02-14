package com.dto;

public class ProductQuantityDTO {
    private String prodid;
    private int quantity;

    public ProductQuantityDTO(String prodid, int quantity) {
        this.prodid = prodid;
        this.quantity = quantity;
    }

    public String getProdid() {
        return prodid;
    }

    public int getQuantity() {
        return quantity;
    }
}
