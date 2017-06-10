package com.vanging.hrms.persistence.models;

public class Order
{
    private long employee_id;
    private long order_id;
    private String customer_point_of_contact;
    private String customer_billing_address;
    private long products_purchased;
    private String datetime;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
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

    public long getProducts_purchased() {
        return products_purchased;
    }

    public void setProducts_purchased(long products_purchased) {
        this.products_purchased = products_purchased;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
