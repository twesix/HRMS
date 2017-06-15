package com.vanging.hrms.persistence.models;

public class Order
{
    private String order_id;

    // to be assigned
    private String employee_id;
    private String customer_point_of_contact;
    private String customer_billing_address;
    private String products_purchased;
    private String date;

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_point_of_contact() {
        return customer_point_of_contact;
    }

    public void setCustomer_point_of_contact(String customer_point_of_contact) {
        this.customer_point_of_contact = customer_point_of_contact;
    }

    public String getCustomer_billing_address() {
        return customer_billing_address;
    }

    public void setCustomer_billing_address(String customer_billing_address) {
        this.customer_billing_address = customer_billing_address;
    }

    public String getProducts_purchased() {
        return products_purchased;
    }

    public void setProducts_purchased(String products_purchased) {
        this.products_purchased = products_purchased;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String datetime) {
        this.date = datetime;
    }
}
