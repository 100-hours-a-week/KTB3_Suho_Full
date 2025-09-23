package org.example.Models;

public class Task {
    Status status;
    String title;

    public Task(String title) {
        this.title = title;
        status = Status.Before;
    }

    public String getTitle() {
        return this.title;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}