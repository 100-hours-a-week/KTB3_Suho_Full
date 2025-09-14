package org.example;

import java.util.ArrayList;

public class ManagementSprint {
    ArrayList<Sprint> sprintArrayList;

    public ManagementSprint() {
        sprintArrayList = new ArrayList<Sprint>();
        sprintArrayList.add(new Sprint(1, "sprint1", "11/22", "11/22"));
        sprintArrayList.add(new Sprint(2, "sprint2", "11/22", "11/22"));
        sprintArrayList.add(new Sprint(3, "sprint3", "11/22", "11/22"));
        sprintArrayList.add(new Sprint(4, "sprint4", "11/22", "11/22"));
    }

    public void showAllSprint() {
        for (int i = 0; i < sprintArrayList.size(); i++) {
            System.out.println("id: " + (i + 1));
            sprintArrayList.get(i).showSprint();
        }
    }

    public void showAllSprintId() {
        for (int i = 0; i < sprintArrayList.size(); i++) {
            System.out.println("id: " + (i + 1) + " | " + sprintArrayList.get(i).title + " | week " + sprintArrayList.get(i).week);
        }
    }

    public void addSprint(int week,String title, String startDate, String endDate) {
        Sprint newSprint = new Sprint(week, title, startDate, endDate);
        sprintArrayList.add(newSprint);
        newSprint.showSprint();
    }

    public void updateSprintTitle(int sprintId, String newTitle) {
        if (sprintId > 0 && sprintId <= sprintArrayList.size()) {
            Sprint sprint = sprintArrayList.get(sprintId - 1);
            sprint.updateTaskTitle(newTitle);
            sprint.showSprint();
        } else {
            System.out.println("존재하지 않는 스프린트 ID입니다.");
        }
    }

    public void updateSprintWeek(int sprintId, int newWeek) {
        if (sprintId > 0 && sprintId <= sprintArrayList.size()) {
            Sprint sprint = sprintArrayList.get(sprintId - 1);
            sprint.week = newWeek;
            sprint.showSprint();
        } else {
            System.out.println("존재하지 않는 스프린트 ID입니다.");
        }
    }

    public void updateSprintStartDate(int sprintId, String newStartDate) {
        if (sprintId > 0 && sprintId <= sprintArrayList.size()) {
            Sprint sprint = sprintArrayList.get(sprintId - 1);
            sprint.startDate = newStartDate;
            sprint.showSprint();
        } else {
            System.out.println("존재하지 않는 스프린트 ID입니다.");
        }
    }

    public void updateSprintEndDate(int sprintId, String newEndDate) {
        if (sprintId > 0 && sprintId <= sprintArrayList.size()) {
            Sprint sprint = sprintArrayList.get(sprintId - 1);
            sprint.endDate = newEndDate;
            sprint.showSprint();
        } else {
            System.out.println("존재하지 않는 스프린트 ID입니다.");
        }
    }

    public void deleteSprint(int sprintId) {
        if (sprintId > 0 && sprintId <= sprintArrayList.size()) {
            sprintArrayList.remove(sprintId - 1);
        } else {
            System.out.println("존재하지 않는 스프린트 ID입니다.");
        }
    }

}
