package org.example.Controllers;

import org.example.Util.DummyData;
import org.example.Util.InputHandler;
import org.example.Util.Enums.ManageOptionKey;
import org.example.View.MenuView.MainMenuView;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainMenuViewController implements ViewController {
    private final MainMenuView mainMenuView;
    private final InputHandler inputHandler;
    private final DummyData dummyData;
    private final MenuActionFactory menuActionFactory;

    public MainMenuViewController(InputHandler inputHandler, DummyData dummyData) {
        this.mainMenuView = new MainMenuView();
        this.inputHandler = inputHandler;
        this.dummyData = dummyData;
        this.menuActionFactory = new MenuActionFactory(inputHandler, dummyData);
    }

    @Override
    public void onAppear() {
        mainMenuView.printMainMenu();
    }

    @Override
    public ViewController nextViewController() {
//        ManageOptionKey optionKey = inputHandler.getManageOptionKey();
//        switch (optionKey) {
//            case SPRINT:
//                return new SprintMenuViewController(inputHandler, dummyData);
//            case BACKLOG:
//                return new BackLogMenuViewController(inputHandler, dummyData);
//            case TASK:
//                return new TaskMenuViewController(inputHandler, dummyData); // 현재 메뉴로 다시 돌아옴
//            case EXIT:
//                return null;
//        }
//        return null;
        MenuActionStrategy strategy = menuActionFactory.getStrategy(inputHandler.getManageOptionKey());
        return strategy.execute();
    }
}

interface MenuActionStrategy {
    ViewController execute();
}

class ManageSprintStrategy implements MenuActionStrategy {
    private final InputHandler inputHandler;
    private final DummyData dummyData;

    public ManageSprintStrategy(InputHandler inputHandler, DummyData dummyData) {
        this.inputHandler = inputHandler;
        this.dummyData = dummyData;
    }

    @Override
    public ViewController execute() {
        return new SprintMenuViewController(inputHandler, dummyData);
    }
}

class MenuActionFactory {
    private final Map<ManageOptionKey, MenuActionStrategy> strategies;

    public MenuActionFactory(InputHandler inputHandler, DummyData dummyData) {
        strategies = new HashMap<>();
        strategies.put(ManageOptionKey.SPRINT, new ManageSprintStrategy(inputHandler, dummyData));
//        strategies.put(ManageOptionKey.BACKLOG, new ManageBackLogStrategy(inputHandler, dummyData));
//        strategies.put(ManageOptionKey.TASK, new ManageTaskStrategy(inputHandler, dummyData));
//        strategies.put(ManageOptionKey.EXIT, new ExitStrategy());
    }

    public MenuActionStrategy getStrategy(ManageOptionKey manageOptionKey) {
        return strategies.get(manageOptionKey);
    }
}
