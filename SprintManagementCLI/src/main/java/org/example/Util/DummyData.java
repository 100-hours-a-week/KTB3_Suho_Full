package org.example.Util;

import org.example.Models.Member;
import org.example.Models.ProductBackLog;
import org.example.Models.Sprint;
import org.example.Models.Task;

import java.util.ArrayList;

public class DummyData {
    public ArrayList<Sprint> dummySprintList;
    public ArrayList<Member> dummyMemberList;

    public DummyData() {
        dummySprintList = new ArrayList<>();
        dummyMemberList = new ArrayList<>();

        // 더미 멤버 생성
        Member member1 = new Member(1, "suho");
        Member member2 = new Member(2, "yun");
        Member member3 = new Member(3, "sei");
        Member member4 = new Member(4, "soy");
        Member member5 = new Member(5, "amy");
        dummyMemberList.add(member1);
        dummyMemberList.add(member2);
        dummyMemberList.add(member3);
        dummyMemberList.add(member4);
        dummyMemberList.add(member5);

        // 더미 스프린트 생성
        Sprint sprint1 = new Sprint(1, "Sprint 1: Project Setup", "09/22", "09/28");
        Sprint sprint2 = new Sprint(2, "Sprint 2: Feature Development", "09/29", "10/05");

        // Sprint 1에 백로그와 태스크 채우기
        ProductBackLog backlog1_1 = new ProductBackLog("User Authentication");
        backlog1_1.setAssignee(member1);
        backlog1_1.addTask(new Task("Design database schema"));
        backlog1_1.addTask(new Task("Implement login API"));
        backlog1_1.addTask(new Task("Create login UI"));
        sprint1.getProductBackLogArrayList().add(backlog1_1); // 스프린트에 백로그 추가

        ProductBackLog backlog1_2 = new ProductBackLog("Setup CI/CD Pipeline");
        backlog1_2.setAssignee(member2);
        backlog1_2.addTask(new Task("Configure Jenkins"));
        backlog1_2.addTask(new Task("Write build scripts"));
        sprint1.getProductBackLogArrayList().add(backlog1_2); // 스프린트에 백로그 추가

        // Sprint 2에 백로그와 태스크 채우기
        ProductBackLog backlog2_1 = new ProductBackLog("Implement Dashboard");
        backlog2_1.setAssignee(member3);
        backlog2_1.addTask(new Task("API for dashboard stats"));
        backlog2_1.addTask(new Task("Frontend for dashboard"));
        sprint2.getProductBackLogArrayList().add(backlog2_1); // 스프린트에 백로그 추가

        ProductBackLog backlog2_2 = new ProductBackLog("User Profile Management");
        backlog2_2.setAssignee(member1);
        backlog2_2.addTask(new Task("API for profile update"));
        backlog2_2.addTask(new Task("Frontend for profile page"));
        sprint2.getProductBackLogArrayList().add(backlog2_2); // 스프린트에 백로그 추가

        dummySprintList.add(sprint1);
        dummySprintList.add(sprint2);
    }

    public ArrayList<Sprint> getDummySprintList() {
        return dummySprintList;
    }

    public void deleteSprint(int sprintId) {
        if (sprintId > 0 && dummySprintList.size() <= sprintId) {
            dummySprintList.remove(sprintId-1);
        }
    }
}
