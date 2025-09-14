package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagementSprint managementSprint = new ManagementSprint();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        
        // 팀원 더미 데이터 생성
        Member[] members = {
            new Member(1, "suho"),
            new Member(2, "yun"),
            new Member(3, "sei"),
            new Member(4, "soy"),
            new Member(5, "amy")
        };
        
        while (flag) {
            System.out.println("1. 스프린트 관리  2. 백로그 관리  3. 테스크 관리  4. CLI종료");
            switch (sc.nextLine()) {
                case "1":
                    managementSprint.showAllSprint();
                    System.out.println("1. 스프린트 추가  2. 스프린트 수정  3. 스프린트 삭제  4. 돌아가기  5. CLI종료");
                    String sprintChoice = sc.nextLine();
                    switch (sprintChoice) {
                        case "1":
                            System.out.println("스프린트 이름을 입력해주세요.");
                            String name = sc.nextLine();
                            System.out.println("스프린트 주차를 설정해주세요");
                            int week = Integer.parseInt(sc.nextLine());
                            System.out.println("시작일을 입력해주세요 (예: MM/DD)");
                            String startDate = sc.nextLine();
                            System.out.println("종료일을 입력해주세요 (예: MM/DD)");
                            String endDate = sc.nextLine();
                            managementSprint.addSprint(week, name, startDate, endDate);
                            System.out.println("스프린트가 추가되었습니다.");
                            break;
                        case "2":
                            System.out.println("수정할 스프린트 ID를 입력해주세요.");
                            int editId = Integer.parseInt(sc.nextLine());
                            boolean optionFlag = true;
                            while (optionFlag) {
                                System.out.println("1. 이름 수정  2. 주차 수정  3. 시작일 수정  4. 종료일 수정  5. 수정 종료");
                                String option = sc.nextLine();
                                switch (option) {
                                    case "1":
                                        System.out.println("새로운 스프린트 이름을 입력해주세요.");
                                        String newName = sc.nextLine();
                                        managementSprint.updateSprintTitle(editId, newName);
                                        System.out.println("스프린트 이름이 수정되었습니다.");
                                        break;
                                    case "2":
                                        System.out.println("새로운 주차를 입력해주세요.");
                                        int newWeek = Integer.parseInt(sc.nextLine());
                                        managementSprint.updateSprintWeek(editId, newWeek);
                                        System.out.println("스프린트 주차가 수정되었습니다.");
                                        break;
                                    case "3":
                                        System.out.println("새로운 시작일을 입력해주세요 (예: MM/DD)");
                                        String newStartDate = sc.nextLine();
                                        managementSprint.updateSprintStartDate(editId, newStartDate);
                                        System.out.println("스프린트 시작일이 수정되었습니다.");
                                        break;
                                    case "4":
                                        System.out.println("새로운 종료일을 입력해주세요 (예: MM/DD)");
                                        String newEndDate = sc.nextLine();
                                        managementSprint.updateSprintEndDate(editId, newEndDate);
                                        System.out.println("스프린트 종료일이 수정되었습니다.");
                                        break;
                                    case "5":
                                        System.out.println("수정을 종료합니다.");
                                        optionFlag = false;
                                        break;
                                    default:
                                        System.out.println("1~5 숫자를 입력해주세요.");
                                }
                            }

                            break;
                        case "3":
                            System.out.println("삭제할 스프린트 ID를 입력해주세요.");
                            int deleteId = Integer.parseInt(sc.nextLine());
                            System.out.println("정말로 삭제하시겠습니까? (y/n)");
                            String confirm = sc.nextLine();
                            if (confirm.equals("y") || confirm.equals("Y")) {
                                managementSprint.deleteSprint(deleteId);
                                System.out.println("스프린트가 삭제되었습니다.");
                            } else {
                                System.out.println("삭제가 취소되었습니다.");
                            }
                            break;
                        case "4":
                            System.out.println("메인 메뉴로 돌아갑니다.");
                            break;
                        case "5":
                            System.out.println("시스템을 종료합니다.");
                            flag = false;
                            sc.close();
                            break;
                        default:
                            System.out.println("1~5 숫자를 입력해주세요.");
                    }
                    break;
                case "2":
                    managementSprint.showAllSprintId();
                    System.out.println("백로그를 확인할 스프린트 ID 입력해주세요.");
                    int sprintId = Integer.parseInt(sc.nextLine());
                    if (sprintId > 0 && sprintId <= managementSprint.sprintArrayList.size()) {
                        managementSprint.sprintArrayList.get(sprintId - 1).showSprint();
                        System.out.println("1. 백로그 추가  2. 백로그 수정  3. 백로그 삭제  4. 돌아가기  5. CLI종료");
                        String backLogChoice = sc.nextLine();
                        switch (backLogChoice) {
                            case "1":
                                System.out.println("백로그 이름을 설정해주세요.");
                                String backLogTitle = sc.nextLine();
                                managementSprint.sprintArrayList.get(sprintId - 1).addBackLog(backLogTitle);
                                System.out.println("백로그가 추가되었습니다.");
                                break;
                            case "2":
                                System.out.println("수정할 백로그 ID를 입력해주세요.");
                                int editBacklogId = Integer.parseInt(sc.nextLine());
                                boolean backlogOptionFlag = true;
                                while (backlogOptionFlag) {
                                    System.out.println("1. 이름 수정  2. 상태 수정  3. 담당자 설정  4. 수정 종료");
                                    String backlogOption = sc.nextLine();
                                    switch (backlogOption) {
                                        case "1":
                                            System.out.println("새로운 백로그 이름을 입력해주세요.");
                                            String newBacklogTitle = sc.nextLine();
                                            managementSprint.sprintArrayList.get(sprintId - 1).updateBackLogTitle(editBacklogId, newBacklogTitle);
                                            System.out.println("백로그 이름이 수정되었습니다.");
                                            break;
                                        case "2":
                                            System.out.println("새로운 상태를 입력해주세요. 1. Before  2. InProgress  3. Done");
                                            String statusInput = sc.nextLine();
                                            Status status = Status.Before;
                                            switch (statusInput) {
                                                case "2":
                                                    status = Status.InProgress;
                                                    break;
                                                case "3":
                                                    status = Status.Done;
                                                    break;
                                            }
                                            managementSprint.sprintArrayList.get(sprintId - 1).updateBackLogStatus(editBacklogId, status);
                                            System.out.println("백로그 상태가 수정되었습니다.");
                                            break;
                                        case "3":
                                            System.out.println("담당자를 선택해주세요:");
                                            for (int i = 0; i < members.length; i++) {
                                                System.out.println((i + 1) + ". " + members[i].name);
                                            }
                                            System.out.println("6. 담당자 없음");
                                            String memberChoice = sc.nextLine();
                                            Member selectedMember = null;
                                            switch (memberChoice) {
                                                case "1":
                                                    selectedMember = members[0];
                                                    break;
                                                case "2":
                                                    selectedMember = members[1];
                                                    break;
                                                case "3":
                                                    selectedMember = members[2];
                                                    break;
                                                case "4":
                                                    selectedMember = members[3];
                                                    break;
                                                case "5":
                                                    selectedMember = members[4];
                                                    break;
                                                case "6":
                                                    selectedMember = null;
                                                    break;
                                                default:
                                                    System.out.println("1~6 숫자를 입력해주세요.");
                                                    continue;
                                            }
                                            managementSprint.sprintArrayList.get(sprintId - 1).setBackLogAssignee(editBacklogId, selectedMember);
                                            System.out.println("담당자가 설정되었습니다.");
                                            break;
                                        case "4":
                                            System.out.println("수정을 종료합니다.");
                                            backlogOptionFlag = false;
                                            break;
                                        default:
                                            System.out.println("1~4 숫자를 입력해주세요.");
                                    }
                                }
                                break;
                            case "3":
                                System.out.println("삭제할 백로그 ID를 입력해주세요.");
                                int deleteBacklogId = Integer.parseInt(sc.nextLine());
                                System.out.println("정말로 삭제하시겠습니까? (y/n)");
                                String backlogConfirm = sc.nextLine();
                                if (backlogConfirm.equals("y") || backlogConfirm.equals("Y")) {
                                    managementSprint.sprintArrayList.get(sprintId - 1).deleteBackLog(deleteBacklogId);
                                    System.out.println("백로그가 삭제되었습니다.");
                                } else {
                                    System.out.println("삭제가 취소되었습니다.");
                                }
                                break;
                            case "4":
                                System.out.println("메인 메뉴로 돌아갑니다.");
                                break;
                            case "5":
                                System.out.println("시스템을 종료합니다.");
                                flag = false;
                                sc.close();
                                break;
                            default:
                                System.out.println("1~5 숫자를 입력해주세요.");
                        }
                    } else {
                        System.out.println("존재하지 않는 스프린트 ID입니다.");
                    }
                    break;
                case "3":
                    System.out.println("테스크를 확인할 스프린트 ID를 입력해주세요.");
                    int taskSprintId = Integer.parseInt(sc.nextLine());
                    if (taskSprintId > 0 && taskSprintId <= managementSprint.sprintArrayList.size()) {
                        managementSprint.sprintArrayList.get(taskSprintId - 1).showSprint();
                        System.out.println("테스크를 확인할 백로그 ID를 입력해주세요.");
                        int taskBacklogId = Integer.parseInt(sc.nextLine());
                        if (taskBacklogId > 0 && taskBacklogId <= managementSprint.sprintArrayList.get(taskSprintId - 1).productBackLogArrayList.size()) {
                            managementSprint.sprintArrayList.get(taskSprintId - 1).productBackLogArrayList.get(taskBacklogId - 1).showAllTasks();
                            System.out.println("1. 테스크 추가  2. 테스크 수정  3. 테스크 삭제  4. 돌아가기  5. CLI종료");
                            String taskChoice = sc.nextLine();
                            switch (taskChoice) {
                                case "1":
                                    System.out.println("테스크 이름을 입력해주세요.");
                                    String taskTitle = sc.nextLine();
                                    managementSprint.sprintArrayList.get(taskSprintId - 1).productBackLogArrayList.get(taskBacklogId - 1).addTask(taskTitle);
                                    System.out.println("테스크가 추가되었습니다.");
                                    break;
                                case "2":
                                    System.out.println("수정할 테스크 ID를 입력해주세요.");
                                    int editTaskId = Integer.parseInt(sc.nextLine());
                                    boolean taskOptionFlag = true;
                                    while (taskOptionFlag) {
                                        System.out.println("1. 이름 수정  2. 상태 수정  3. 수정 종료");
                                        String taskOption = sc.nextLine();
                                        switch (taskOption) {
                                            case "1":
                                                System.out.println("새로운 테스크 이름을 입력해주세요.");
                                                String newTaskTitle = sc.nextLine();
                                                managementSprint.sprintArrayList.get(taskSprintId - 1).productBackLogArrayList.get(taskBacklogId - 1).updateTaskTitle(editTaskId, newTaskTitle);
                                                System.out.println("테스크 이름이 수정되었습니다.");
                                                break;
                                            case "2":
                                                System.out.println("새로운 상태를 입력해주세요. 1. Before  2. InProgress  3. Done");
                                                String taskStatusInput = sc.nextLine();
                                                Status taskStatus = Status.Before;
                                                switch (taskStatusInput) {
                                                    case "2":
                                                        taskStatus = Status.InProgress;
                                                        break;
                                                    case "3":
                                                        taskStatus = Status.Done;
                                                        break;
                                                }
                                                managementSprint.sprintArrayList.get(taskSprintId - 1).productBackLogArrayList.get(taskBacklogId - 1).updateTaskStatus(editTaskId, taskStatus);
                                                System.out.println("테스크 상태가 수정되었습니다.");
                                                break;
                                            case "3":
                                                System.out.println("수정을 종료합니다.");
                                                taskOptionFlag = false;
                                                break;
                                            default:
                                                System.out.println("1~3 숫자를 입력해주세요.");
                                        }
                                    }
                                    break;
                                case "3":
                                    System.out.println("삭제할 테스크 ID를 입력해주세요.");
                                    int deleteTaskId = Integer.parseInt(sc.nextLine());
                                    System.out.println("정말로 삭제하시겠습니까? (y/n)");
                                    String taskConfirm = sc.nextLine();
                                    if (taskConfirm.equals("y") || taskConfirm.equals("Y")) {
                                        managementSprint.sprintArrayList.get(taskSprintId - 1).productBackLogArrayList.get(taskBacklogId - 1).deleteTask(deleteTaskId);
                                        System.out.println("테스크가 삭제되었습니다.");
                                    } else {
                                        System.out.println("삭제가 취소되었습니다.");
                                    }
                                    break;
                                case "4":
                                    System.out.println("메인 메뉴로 돌아갑니다.");
                                    break;
                                case "5":
                                    System.out.println("시스템을 종료합니다.");
                                    flag = false;
                                    sc.close();
                                    break;
                                default:
                                    System.out.println("1~5 숫자를 입력해주세요.");
                            }
                        } else {
                            System.out.println("존재하지 않는 백로그 ID입니다.");
                        }
                    } else {
                        System.out.println("존재하지 않는 스프린트 ID입니다.");
                    }
                    break;
                case "4":
                    System.out.println("시스템을 종료합니다.");
                    flag = false;
                    sc.close();
                    break;
                default:
                    System.out.println("1~4 숫자 입력해주세요");
            }

        }
    }
}