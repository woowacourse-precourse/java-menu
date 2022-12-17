package menu.utils;

public class MemberValid {
    public static final int MIN_NAME = 2;
    public static final int MAX_NAME = 4;
    public static final int MIN_COUNT = 2;
    public static final int MAX_COUNT = 5;
    public static final int MIN_NOTEAT = 0;
    public static final int MAX_NOTEAT = 2;

    public static void isValidMember(String[] members) {
        isCorrectCount(members);
        for (String member : members) {
            isCorrectLength(member);
        }
    }

    public static void isValidNotEat(String[] notEats) {
        if (notEats.length < MIN_NOTEAT || notEats.length > MAX_NOTEAT) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최소 0개, 최대 2개여야 합니다.");
        }
    }

    private static void isCorrectLength(String member) {
        if (member.length() < MIN_NAME || member.length() > MAX_NAME) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자여야 합니다.");
        }
    }

    private static void isCorrectCount(String[] members) {
        if (members.length < MIN_COUNT || members.length > MAX_COUNT) {
            throw new IllegalArgumentException("코치는 최소 2명 이상, 5명이하여야 합니다.");
        }
    }
}
