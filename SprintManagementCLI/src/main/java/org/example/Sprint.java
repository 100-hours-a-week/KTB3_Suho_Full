package org.example;


import java.util.ArrayList;

class Sprint extends Task{
    int week;
    String startDate;
    String endDate;
    ArrayList<ProductBackLog> productBackLogArrayList;

    public Sprint(int week, String title, String startDate, String endDate) {
        super(title);
        this.week = week;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productBackLogArrayList = new ArrayList<ProductBackLog>();
        productBackLogArrayList.add(new ProductBackLog("backlog1"));
        productBackLogArrayList.add(new ProductBackLog("backlog2"));
        productBackLogArrayList.add(new ProductBackLog("backlog3"));
        productBackLogArrayList.add(new ProductBackLog("backlog4"));
    }

    public void showSprint() {
        System.out.println(status.getLabel() + "| " + title + " |  Week " + week + " | " + startDate + " -> " + endDate);
        System.out.println("Product Back Log: ");
        for(int i = 0; i < productBackLogArrayList.size(); i++) {
            productBackLogArrayList.get(i).showProductBackLog(i + 1);
        }
        System.out.println("----------------------------------------");
    }

    public void addBackLog(String title) {
        productBackLogArrayList.add(new ProductBackLog(title));
    }

    public void updateBackLogTitle(int backlogId, String newTitle) {
        if (backlogId > 0 && backlogId <= productBackLogArrayList.size()) {
            ProductBackLog backlog = productBackLogArrayList.get(backlogId - 1);
            backlog.updateTaskTitle(newTitle);
        } else {
            System.out.println("존재하지 않는 백로그 ID입니다.");
        }
    }

    public void updateBackLogStatus(int backlogId, Status newStatus) {
        if (backlogId > 0 && backlogId <= productBackLogArrayList.size()) {
            ProductBackLog backlog = productBackLogArrayList.get(backlogId - 1);
            backlog.updateTaskStatus(newStatus);
        } else {
            System.out.println("존재하지 않는 백로그 ID입니다.");
        }
    }

    public void deleteBackLog(int backlogId) {
        if (backlogId > 0 && backlogId <= productBackLogArrayList.size()) {
            productBackLogArrayList.remove(backlogId - 1);
        } else {
            System.out.println("존재하지 않는 백로그 ID입니다.");
        }
    }

    public void setBackLogAssignee(int backlogId, Member assignee) {
        if (backlogId > 0 && backlogId <= productBackLogArrayList.size()) {
            ProductBackLog backlog = productBackLogArrayList.get(backlogId - 1);
            backlog.setAssignee(assignee);
        } else {
            System.out.println("존재하지 않는 백로그 ID입니다.");
        }
    }

}