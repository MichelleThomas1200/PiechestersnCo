package com.example.piechestersnco.Models;

public class CartModel {
    int cartImage;//int since images are in folder:drawable
    String soldItemName, price, orderNumber;

    public CartModel(int cartImage, String soldItemName, String price, String orderNumber) {
        this.cartImage = cartImage;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public CartModel() {

    }

    public int getCartImage() {
        return cartImage;
    }

    public void setCartImage(int cartImage) {
        this.cartImage = cartImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
