package org.example.View.MenuView;

import org.example.Models.Member;
import org.example.Models.ProductBackLog;
import org.example.Models.Sprint;

import java.util.ArrayList;

public abstract class SubMenuView {

    public void printSubMenu() {

    }

    public void printSprintList(ArrayList<Sprint> sprintList) {
        System.out.println("------------------- Sprint List -----------------------------");
        for (int i = 0; i < sprintList.size(); i++) {
            Sprint sprint = sprintList.get(i);
            System.out.println("스프린트 ID: " + (i + 1) + " | " +
                    sprint.getStatus().getLabel() + " | " +
                    sprint.getTitle() + " | " +
                    "week" + sprint.getWeek() + " | " +
                    sprint.getPeriod()
            );
            this.printBackLogList(sprint.getProductBackLogArrayList());
        }
        System.out.println("백로그가 속한 스프린트의 ID를 숫자로 입력해주세요.");
    }

    protected void printAlertInputId(){

    }

    public void printGoBackMenu(){
        System.out.println("이전 메뉴로 돌아갑니다.");
    }

    protected void printBackLogList(ArrayList<ProductBackLog> backLogList){

    }
}
