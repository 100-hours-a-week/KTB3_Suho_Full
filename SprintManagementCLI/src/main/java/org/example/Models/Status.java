package org.example.Models;

public enum Status {
    Before("    Before"), InProgress("Inprogress"), Done("      Done");
    private String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}