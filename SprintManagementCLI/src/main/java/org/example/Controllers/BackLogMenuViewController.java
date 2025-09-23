package org.example.Controllers;

import org.example.Models.ProductBackLog;
import org.example.Util.DummyData;
import org.example.Util.Enums.SubMenuOptionKey;
import org.example.Util.InputHandler;
import org.example.View.MenuView.BackLogMenuView;

public class BackLogMenuViewController implements ViewController {
    private final BackLogMenuView backLogMenuView;
    private final InputHandler inputHandler;
    private final DummyData dummyData;
    private int sprintId;

    public BackLogMenuViewController(InputHandler inputHandler, DummyData dummyData) {
        this.backLogMenuView = new BackLogMenuView();
        this.inputHandler = inputHandler;
        this.dummyData = dummyData;
    }

    @Override
    public void onAppear() {
        // 스프린트 리스트 나옴.
        backLogMenuView.printSprintList(dummyData.getDummySprintList());
        while (true) {
            // 숫자 입력 받음.
            sprintId = inputHandler.getNum();
            // id가 유효한지 확인.
            if (sprintId > 0 && sprintId <= dummyData.getDummySprintList().size()) {
                backLogMenuView.printBackLogList(dummyData.getDummySprintList().get(sprintId-1));
                break;
            }
            else {
                System.out.println("스프린트 ID가 올바르지 않습니다.");
            }
        }
        backLogMenuView.printSubMenu();
    }

    @Override
    public ViewController nextViewController() {
        SubMenuOptionKey optionKey = inputHandler.getSprintSubMenuOptionKey();
        System.out.println("-------------------------------------------------------------");
        switch (optionKey) {
            case ADD:
                this.addBackLog();
                System.out.println("백로그가 추가됐습니다.");
                return this;
            case UPDATE:
                System.out.println("백로그 수정 기능은 아직 준비중입니다.");
                return this;
            case DELETE:
                int backLogId = this.deleteBack();
                System.out.println("ID: " + backLogId + " 백로그가 삭제됐습니다.");
                return this;
            case GO_BACK:
                this.backLogMenuView.printGoBackMenu();
                return new MainMenuViewController(inputHandler, dummyData);
            case EXIT:
                return null;
        }
        return null;
    }

    private void addBackLog() {
        System.out.println("Back Log 제목을 입력해주세요.");
        String title = inputHandler.getString();
        ProductBackLog backLog = new ProductBackLog(title);
        dummyData.dummySprintList.get(sprintId-1).addProductBackLog(backLog);
    }

    private int deleteBack() {
        System.out.println("삭제하실 Back Log의 ID를 숫자로 입력해주세요.");
        while (true) {
            // 숫자 입력 받음.
            int backLogId = inputHandler.getNum();
            // id가 유효한지 확인.
            if (backLogId > 0 && backLogId <= dummyData.getDummySprintList().get(sprintId-1).getProductBackLogArrayList().size()) {
                //유효하면 해당 id 삭제
                dummyData.getDummySprintList().get(sprintId-1).deleteBackLog(backLogId);
                backLogMenuView.printBackLogList(dummyData.getDummySprintList().get(sprintId-1));
                return backLogId;
            }
            else {
                System.out.println("백로그 ID가 올바르지 않습니다.");
            }
        }
    }
}
