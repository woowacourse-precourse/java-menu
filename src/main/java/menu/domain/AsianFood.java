package menu.domain;

public enum AsianFood {
    PHAT_THAI("팟타이"),
    KHAO_PHAT("카오 팟"),
    NASI_GORENG("나시고렝"),
    FRIED_RICE_WITH_PINEAPPLE("파인애플 볶음밥"),
    RICE_NOODLES("쌀국수"),
    TOM_YAM_GOONG("똠얌꿍"),
    BANH_MI("반미"),
    VIETNAMESE_SPRING_ROLLS("월남쌈"),
    BUN_CHA("분짜");

    String name;

    AsianFood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
