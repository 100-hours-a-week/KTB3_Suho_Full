package org.example.View.MenuView;

import org.example.Models.Member;
import org.example.Models.ProductBackLog;
import org.example.Models.Sprint;

import java.util.ArrayList;

public class BackLogMenuView extends SubMenuView {
    public void printSubMenu() {
        System.out.println("1. BackLog 추가  2. BackLog 수정  3. BackLog 삭제  4. 돌아가기  5. CLI 종료");
    }

    public void printBackLogList(Sprint sprint) {
        System.out.println("-------------------------------------------------------------");
        System.out.println(
                sprint.getStatus().name() + " | " +
                        sprint.getTitle() + " | " +
                        "week" + sprint.getWeek() + " | " +
                        sprint.getPeriod()
        );

        System.out.println("------------------ Back Log List ----------------------------");

        for(int i = 0; sprint.getProductBackLogArrayList().size() > i; i++) {
            ProductBackLog backLog = sprint.getProductBackLogArrayList().get(i);
            Member assignee = backLog.getAssignee();
            System.out.println("ID: " + (i+1) + " | " + backLog.getStatus().getLabel() + " | " +
                    backLog.getTitle() + " | 담당자: " +
                    (assignee != null ? assignee.getName() : "None")
            );
        }
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    protected void printBackLogList(ArrayList<ProductBackLog> backLogList) {
        for(ProductBackLog backLog: backLogList) {
            Member assignee = backLog.getAssignee();
            System.out.println("  ㄴ " + backLog.getStatus().getLabel() + " | " +
                    backLog.getTitle() + " | 담당자: " +
                    (assignee != null ? assignee.getName() : "None")
            );
        }
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    protected void printAlertInputId(){
        System.out.println("백로그가 속한 스프린트의 ID를 숫자로 입력해주세요.");
    }

}
