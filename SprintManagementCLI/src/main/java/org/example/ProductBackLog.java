package org.example;

import java.util.ArrayList;

class ProductBackLog extends Task {
    Member assignee;
    ArrayList<Task> taskArrayList;

    ProductBackLog(String title) {
        super(title);
        taskArrayList = new ArrayList<Task>();
        taskArrayList.add(new Task("task1"));
        taskArrayList.add(new Task("task2"));
        taskArrayList.add(new Task("task3"));
        taskArrayList.add(new Task("task4"));
    }

    public void setAssignee(Member assignee) {
        this.assignee = assignee;
    }

    public void showProductBackLog(int backlogId) {
        System.out.println(this.status.getLabel() + "| id: "+ backlogId + " | " + this.title + " | 담당자: " + (assignee != null ? assignee.name : ""));
    }

    public void showAllTasks() {
        System.out.println("Tasks:");
        for(int i = 0; i < taskArrayList.size(); i++) {
            taskArrayList.get(i).showTask(i + 1);
        }
    }

    public void addTask(String title) {
        taskArrayList.add(new Task(title));
    }

    public void updateTaskTitle(int taskId, String newTitle) {
        if (taskId > 0 && taskId <= taskArrayList.size()) {
            Task task = taskArrayList.get(taskId - 1);
            task.updateTaskTitle(newTitle);
        } else {
            System.out.println("존재하지 않는 테스크 ID입니다.");
        }
    }

    public void updateTaskStatus(int taskId, Status newStatus) {
        if (taskId > 0 && taskId <= taskArrayList.size()) {
            Task task = taskArrayList.get(taskId - 1);
            task.updateTaskStatus(newStatus);
        } else {
            System.out.println("존재하지 않는 테스크 ID입니다.");
        }
    }

    public void deleteTask(int taskId) {
        if (taskId > 0 && taskId <= taskArrayList.size()) {
            taskArrayList.remove(taskId - 1);
        } else {
            System.out.println("존재하지 않는 테스크 ID입니다.");
        }
    }
}