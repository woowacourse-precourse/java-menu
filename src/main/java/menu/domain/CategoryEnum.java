package menu.domain;

public enum CategoryEnum {
    MONDAY(1,"월요일"), TUESDAY(2,"화요일"), WEDNESDAY(3,"수요일"), THURSDAY(4,"목요일"), FRIDAY(5,"금요일");

    final private Integer value;
    final private String msg;

    CategoryEnum(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public Integer getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }

    public static String getMessageByValue(Integer val) {
        for (CategoryEnum categoryEnum : CategoryEnum.values()) {
            if (categoryEnum.getValue() == val)
                return categoryEnum.getMsg();
        }
        return "";
    }
}
