package org.example.Controllers;

import org.example.Util.DummyData;
import org.example.Util.InputHandler;
import org.example.View.MenuView.SprintMenuView;
import org.example.View.MenuView.TaskMenuView;

public class TaskMenuViewController implements ViewController {
    private TaskMenuView taskMenuView;
    private final InputHandler inputHandler;
    private final DummyData dummyData;
    private int backLogId;

    public TaskMenuViewController(InputHandler inputHandler, DummyData dummyData) {
        taskMenuView = new TaskMenuView();
        this.inputHandler = inputHandler;
        this.dummyData = dummyData;
    }


    @Override
    public void onAppear() {
        taskMenuView.printSubMenu();
        taskMenuView.printSprintList(dummyData.getDummySprintList());
        while (true) {
            int sprintId = inputHandler.getNum();
            if (sprintId > 0 && sprintId < dummyData.getDummySprintList().size()) {

            }
        }
    }

    @Override
    public ViewController nextViewController() {
        return null;
    }
}
