package org.example.Models;


import java.util.ArrayList;

public class Sprint extends Task{
    private int week;
    private String startDate;
    private String endDate;
    private ArrayList<ProductBackLog> productBackLogArrayList;

    public Sprint(int week, String title, String startDate, String endDate) {
        super(title);
        this.week = week;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productBackLogArrayList = new ArrayList<>();
    }

    public String getPeriod() {
        return startDate + " ~ " + endDate;
    }

    public int getWeek() {
        return week;
    }

    public synchronized ArrayList<ProductBackLog> getProductBackLogArrayList() {
        return productBackLogArrayList;
    }

    public synchronized void deleteBackLog(int sprintId) {
        productBackLogArrayList.remove(sprintId-1);
    }

    public synchronized void addProductBackLog(ProductBackLog productBackLog) {
        productBackLogArrayList.add(productBackLog);
    }
}