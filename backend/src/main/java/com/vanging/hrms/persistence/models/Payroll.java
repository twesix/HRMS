package com.vanging.hrms.persistence.models;

public class Payroll
{
    private long id;
    private long employee_id;
    private long amount;
    private boolean settled;
    private String settle_time;
    private String grant_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isSettled() {
        return settled;
    }

    public void setSettled(boolean settled) {
        this.settled = settled;
    }

    public String getSettle_time() {
        return settle_time;
    }

    public void setSettle_time(String settle_time) {
        this.settle_time = settle_time;
    }

    public String getGrant_time() {
        return grant_time;
    }

    public void setGrant_time(String grant_time) {
        this.grant_time = grant_time;
    }
}
