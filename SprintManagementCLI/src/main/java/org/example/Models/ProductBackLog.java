package org.example.Models;

import java.util.ArrayList;

public class ProductBackLog extends Task {
    private Member assignee;
    ArrayList<Task> taskArrayList;

    public ProductBackLog(String title) {
        super(title);
        this.taskArrayList = new ArrayList<>();
    }

    public synchronized ArrayList<Task> getTaskArrayList() {
        return this.taskArrayList;
    }

    public void setAssignee(Member assignee) {
        this.assignee = assignee;
    }

    public Member getAssignee() {
        return this.assignee;
    }

    public synchronized void addTask(Task task) {
        this.taskArrayList.add(task);
    }
}