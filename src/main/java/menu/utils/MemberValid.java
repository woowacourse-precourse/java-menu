package menu.utils;

public class MemberValid {
    public static final int MIN_NAME = 2;
    public static final int MAX_NAME = 4;
    public static final int MIN_COUNT = 2;
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
            throw new IllegalArgumentException();
        }
    }

    private static void isCorrectLength(String member) {
        if (member.length() < MIN_NAME || member.length() > MAX_NAME) {
            throw new IllegalArgumentException();
        }
    }

    private static void isCorrectCount(String[] members) {
        if (members.length < MIN_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
