package org.example.Util;

import org.example.Util.Enums.ManageOptionKey;
import org.example.Util.Enums.SubMenuOptionKey;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;
    private String key;
    public InputHandler() {
        scanner = new Scanner(System.in);
    }
    public ManageOptionKey getManageOptionKey() {
            while(true) {
            key = scanner.nextLine();
            ManageOptionKey manageOptionKey = ManageOptionKey.getFromKey(key);
            if(manageOptionKey != null) {
                return manageOptionKey;
            }
            else {
                System.out.println("1~4 숫자로 다시 입력해주세요.");
            }
        }
    }

    public SubMenuOptionKey getSprintSubMenuOptionKey() {
        while(true) {
            key = scanner.nextLine();
            SubMenuOptionKey sprintSubMenuOptionKey = SubMenuOptionKey.getFromKey(key);
            if(sprintSubMenuOptionKey != null) {
                return sprintSubMenuOptionKey;
            }
            else {
                System.out.println("1~5 숫자로 다시 입력해주세요.");
            }
        }
    }

    public int getNum() {
        while(true) {
            try {
                key = scanner.nextLine();
                int num = Integer.parseInt(key);
                if (num > 0){
                    return num;
                }
                else {
                    System.out.println("0보다 커야합니다. 다시 입력해주세요.");
                }
            }catch (NumberFormatException e) {
                System.out.println("숫자로 다시 입력해주세요.");
            }
        }
    }

    public String getString() {
        return scanner.nextLine();
    }

    public String getDate() {
        while(true) {
            key = scanner.nextLine();
            String regex = "^(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[0-1])$";
            boolean isMatch = key.matches(regex);
            if(isMatch) {
                return key;
            }
            else {
                System.out.println("MM/DD 형식으로 다시 입력해주세요.");
            }
        }
    }
}
