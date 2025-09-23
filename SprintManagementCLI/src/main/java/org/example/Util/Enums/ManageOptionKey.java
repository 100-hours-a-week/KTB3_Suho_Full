package org.example.Util.Enums;

public enum ManageOptionKey {
    SPRINT("1"),
    BACKLOG("2"),
    TASK("3"),
    EXIT("4");

    private final String optionKey;

    ManageOptionKey(String optionKey) {
        this.optionKey = optionKey;
    }

    public static ManageOptionKey getFromKey(String optionKey) {
        for (ManageOptionKey key : ManageOptionKey.values()) {
            if (key.optionKey.equals(optionKey)) {
                return key;
            }
        }
        return null;
    }
}
