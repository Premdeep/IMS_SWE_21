package com.hpp.ims.model;

public class Orders {

    private String username;
    private String email;
    private String product_name_1;
    private String product_quantity_1;

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmailI(String email) {
        this.email = email;
    }

    public String getProductName() {
        return product_name_1;
    }

    public void setProductName(String product_name_1) {
        this.product_name_1 = product_name_1;
    }

    public String getProductQuantity() {
        return product_quantity_1;
    }

    public void setProductQuantity(String product_quantity_1) {
        this.product_quantity_1 = product_quantity_1;
    }

    @Override
    public String toString() {
        return "Hospital [userName=" + username + ", email=" + email + ", PproductName=" + product_name_1
                + ", productQuantity=" + product_quantity_1 + "]";
    }

    public Orders() {
		
		System.out.println("Orders Constructor");
	}

}
