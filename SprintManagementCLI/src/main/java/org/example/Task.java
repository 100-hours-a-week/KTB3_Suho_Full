package org.example;

class Task {
    Status status;
    String title;

    Task(String title) {
        this.title = title;
        status = Status.Before;
    }

    public void showTask(int taskId) {
        System.out.println(status.getLabel() + "| id: " + taskId + " | " + title);
    }
    public void updateTaskTitle(String title) {
        this.title = title;
    }
    public void updateTaskStatus(Status status) {
        this.status = status;
    }
}