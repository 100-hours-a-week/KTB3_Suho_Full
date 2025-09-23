package org.example.Util.Enums;

public enum SubMenuOptionKey {
    ADD("1"),
    UPDATE("2"),
    DELETE("3"),
    GO_BACK("4"),
    EXIT("5");

    private final String key;

    SubMenuOptionKey(String key) {
        this.key = key;
    }

    public static SubMenuOptionKey getFromKey(String key) {
        for (SubMenuOptionKey optionKey : values()) {
            if (optionKey.key.equals(key)) {
                return optionKey;
            }
        }
        return null;
    }
}
