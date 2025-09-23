package org.example.Controllers;

import org.example.Models.Sprint;
import org.example.Util.DummyData;
import org.example.Util.Enums.SubMenuOptionKey;
import org.example.Util.InputHandler;
import org.example.View.MenuView.SprintMenuView;

public final class SprintMenuViewController implements ViewController {
    private SprintMenuView sprintMenuView;
    private final InputHandler inputHandler;
    private final DummyData dummyData;

    public SprintMenuViewController(InputHandler inputHandler, DummyData dummyData) {
        sprintMenuView = new SprintMenuView();
        this.inputHandler = inputHandler;
        this.dummyData = dummyData;
    }

    @Override
    public void onAppear() {
            sprintMenuView.printSprintList(dummyData.getDummySprintList());
            sprintMenuView.printSubMenu();
    }

    @Override
    public ViewController nextViewController() {
        SubMenuOptionKey optionKey = inputHandler.getSprintSubMenuOptionKey();
        System.out.println("-------------------------------------------------------------");
        switch (optionKey) {
            case ADD:
                this.addSprint();
                System.out.println("스프린트가 추가됐습니다.");
                return this;
            case UPDATE:
                System.out.println("스프린트 수정 기능은 아직 준비중입니다.");
                return this;
            case DELETE:
                int sprintId = this.deleteSprint();
                System.out.println("ID: " + sprintId + " 스프린트가 삭제됐습니다.");
                return this;
            case GO_BACK:
                this.sprintMenuView.printGoBackMenu();
                return new MainMenuViewController(inputHandler, dummyData);
            case EXIT:
                return null;
        }
        return null;
    }

    private void addSprint() {
        int week;
        String startDate;
        String title;
        String endDate;

        System.out.println("스프린트 이름을 입력해주세요.");
        title = inputHandler.getString();
        System.out.println("주차를 입력해주세요.");
        week = inputHandler.getNum();
        System.out.println("시작 날짜를 입력해주세요.MM/DD");
        startDate = inputHandler.getDate();
        System.out.println("종료 날짜를 입력해주세요. MM/DD");
        endDate = inputHandler.getDate();

        Sprint newSprint = new Sprint(week, title, startDate, endDate);
        dummyData.dummySprintList.add(newSprint);
    }

    private int deleteSprint() {
        int sprintId;
        System.out.println("삭제할 스프린트의 ID를 숫자로 입력해주세요.");
        sprintId = inputHandler.getNum();
        dummyData.deleteSprint(sprintId);
        return sprintId;
    }
}
