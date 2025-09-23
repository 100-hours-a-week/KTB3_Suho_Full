package org.example.Util;

import org.example.Models.*;

import java.util.ArrayList;
import java.util.Random;

public class EventGenerator implements Runnable {
    private final DummyData dummyData;
    private final Random random = new Random();

    public EventGenerator(DummyData dummyData) {
        this.dummyData = dummyData;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // 10초에서 20초 사이의 무작위 시간 동안 대기
                int sleepTime = (10 + random.nextInt(11)) * 1000;
                Thread.sleep(sleepTime);

                // 1. 무작위 스프린트 선택
                ArrayList<Sprint> sprints = dummyData.getDummySprintList();
                if (sprints.isEmpty()) continue;
                Sprint randomSprint = sprints.get(random.nextInt(sprints.size()));

                // 2. 무작위 백로그 선택
                ArrayList<ProductBackLog> backlogs = randomSprint.getProductBackLogArrayList();
                if (backlogs.isEmpty()) continue;
                ProductBackLog randomBacklog = backlogs.get(random.nextInt(backlogs.size()));

                // 3. 무작위 태스크 선택
                ArrayList<Task> tasks = randomBacklog.getTaskArrayList();
                if (tasks.isEmpty()) continue;
                Task randomTask = tasks.get(random.nextInt(tasks.size()));

                // 4. 상태를 순차적으로 변경 (Before -> InProgress -> Done)
                Status currentStatus = randomTask.getStatus();
                Status newStatus = null;

                if (currentStatus == Status.Before) {
                    newStatus = Status.InProgress;
                } else if (currentStatus == Status.InProgress) {
                    newStatus = Status.Done;
                } // 'Done' 상태이면 newStatus는 null로 유지되어 아무 작업도 하지 않음

                if (newStatus != null) {
                    randomTask.setStatus(newStatus);
                    // 콘솔에 직접 출력
                    System.out.printf(
                            "\n[EVENT] 스프린트 '%s'의 태스크 '%s' 상태가 '%s'(으)로 진행되었습니다!\n",
                            randomSprint.getTitle(), randomTask.getTitle(), newStatus);
                }

            } catch (InterruptedException e) {
                System.out.println("이벤트 생성 스레드가 중지됩니다.");
                Thread.currentThread().interrupt();
            }
        }
    }
}