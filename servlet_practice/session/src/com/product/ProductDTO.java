package com.product;


public class ProductDTO {
    private String productName;
    private String productId;
    private int productAmount;

    public ProductDTO(String productName, String productId, int productAmount) {
        this.productName = productName;
        this.productId = productId;
        this.productAmount = productAmount;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int amount) {
        this.productAmount = amount;
    }
}
