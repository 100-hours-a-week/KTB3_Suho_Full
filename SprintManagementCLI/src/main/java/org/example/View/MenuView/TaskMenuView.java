package org.example.View.MenuView;

import org.example.Models.Member;
import org.example.Models.ProductBackLog;
import org.example.Models.Sprint;
import org.example.Models.Task;

import java.util.ArrayList;

public class TaskMenuView extends SubMenuView {

    @Override
    public void printSubMenu() {
        System.out.println("1. Task 추가  2. Task 수정  3. Task 삭제  4. 돌아가기  5. CLI 종료");
    }

    @Override
    public void printBackLogList(ArrayList<ProductBackLog> backLogList) {
        int backLogId = 1;
        for(ProductBackLog backLog: backLogList) {
            Member assignee = backLog.getAssignee();
            System.out.println("  ㄴ " + backLog.getStatus().getLabel() + " | " +
                    backLog.getTitle() + " | 담당자: " +
                    (assignee != null ? assignee.getName() : "None")
            );
            for(Task task: backLog.getTaskArrayList()){
                System.out.println("     ㄴ " + task.getStatus().getLabel() + " | " + task.getTitle());
            }
        }
        System.out.println("-------------------------------------------------------------");
    }

    public void printTaskList(ProductBackLog backLog) {
        Member assignee = backLog.getAssignee();
        System.out.println("-------------------------------------------------------------");
        System.out.println(
                backLog.getStatus().name() + " | " +
                        backLog.getTitle() + " | " +
                        "담당자: " + (assignee  != null ? assignee : "None")
        );

        System.out.println("------------------ Task List ----------------------------");

        for(int i = 0; backLog.getTaskArrayList().size() > i; i++) {
            Task task = backLog.getTaskArrayList().get(i);
            System.out.println("ID: " + (i+1) + " | " + task.getStatus().getLabel() + " | " +
                    task.getTitle()
            );
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("관리하고 싶은 테스크의 ID를 숫자로 입력해주세요.");
    }

    @Override
    protected void printAlertInputId() {
        System.out.println("관리하려는 테스크가 속한 스프린트 ID를 숫자로 입력해주세요.");
    }

}
