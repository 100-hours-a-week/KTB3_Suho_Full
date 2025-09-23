package org.example.View.MenuView;

import org.example.Models.Member;
import org.example.Models.ProductBackLog;
import org.example.Models.Sprint;

import java.util.ArrayList;

public class SprintMenuView  extends SubMenuView{

    @Override
    public void printSubMenu() {
        System.out.println("1. Sprint 추가  2. Sprint 수정  3. Sprint 삭제  4. 돌아가기  5. CLI 종료");
    }

}