package com.dto;

public class ProductDTO {
    private String prodid;
    private String prodname;
    private int price;
    private int quantity;

    public ProductDTO(String prodid, String prodname, int price, int quantity) {
        this.prodid = prodid;
        this.prodname = prodname;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProdid() {
        return prodid;
    }

    public String getProdname() {
        return prodname;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
