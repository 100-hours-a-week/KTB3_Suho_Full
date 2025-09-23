package org.example.Controllers;

import org.example.Util.DummyData;
import org.example.Util.InputHandler;
import org.example.Util.Enums.ManageOptionKey;
import org.example.View.MenuView.MainMenuView;

public class MainMenuViewController implements ViewController {
    private final MainMenuView mainMenuView;
    private final InputHandler inputHandler;
    private final DummyData dummyData;

    public MainMenuViewController(InputHandler inputHandler, DummyData dummyData) {
        this.mainMenuView = new MainMenuView();
        this.inputHandler = inputHandler;
        this.dummyData = dummyData;
    }

    @Override
    public void onAppear() {
        mainMenuView.printMainMenu();
    }

    @Override
    public ViewController nextViewController() {
        ManageOptionKey optionKey = inputHandler.getManageOptionKey();
        switch (optionKey) {
            case SPRINT:
                return new SprintMenuViewController(inputHandler, dummyData);
            case BACKLOG:
                return new BackLogMenuViewController(inputHandler, dummyData);
            case TASK:
                return new TaskMenuViewController(inputHandler, dummyData); // 현재 메뉴로 다시 돌아옴
            case EXIT:
                return null;
        }
        return null;
    }
}