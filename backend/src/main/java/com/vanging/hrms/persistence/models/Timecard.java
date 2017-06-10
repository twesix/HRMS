package com.vanging.hrms.persistence.models;

public class Timecard
{
    private long project_id;
    private long employee_id;
    private String datetime;
    private int start_time;
    private int end_time;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int from) {
        this.start_time = from;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int to) {
        this.end_time = to;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }
}
