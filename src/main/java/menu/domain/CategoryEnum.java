package menu.domain;

public enum CategoryEnum {
    JAPANESE(1,"일식"), KOREAN(2,"한식"), CHINESE(3,"중식"), ASIAN(4,"아시안"), WESTERN(5,"양식");

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
