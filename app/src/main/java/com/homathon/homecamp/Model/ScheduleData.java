package com.homathon.homecamp.Model;

public class ScheduleData {
    private String time;
    private String name;
    private int status;

    public ScheduleData(String time, String name, int status) {
        this.time = time;
        this.name = name;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
