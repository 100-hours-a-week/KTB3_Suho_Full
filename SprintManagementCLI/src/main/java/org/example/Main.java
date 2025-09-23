package org.example;

import org.example.Controllers.MainMenuViewController;
import org.example.Controllers.ViewController;
import org.example.Util.DummyData;
import org.example.Util.EventGenerator;
import org.example.Util.InputHandler;

public class Main {
    public static void main(String[] args) {
        DummyData dummyData = new DummyData();
        InputHandler inputHandler = new InputHandler();

        // 이벤트 생성 스레드 ( 무작위 Task의 상태를 진행시킴 ) Before -> InProgress -> Done
        EventGenerator eventGenerator = new EventGenerator(dummyData);
        Thread eventThread = new Thread(eventGenerator);
        eventThread.start();
        System.out.println("[SYSTEM] 무작위 이벤트 스레드가 시작되었습니다.");

        ViewController viewController = new MainMenuViewController(inputHandler, dummyData);

        while(viewController != null) {
            viewController.onAppear();
            viewController = viewController.nextViewController();
        }
        System.out.println("시스템을 종료합니다.");
    }
}
