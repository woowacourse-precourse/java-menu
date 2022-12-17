package menu;

public interface ErrorMessage {
    String PREFIX = "[ERROR] ";
    String INVALID_COACH_MIN ="코치는 최소 2명과 식사를 합니다.";
    String INVALID_COACH_NAX = "코치는 최대 5명과 식사를 합니다.";
    String INVALID_INEDIBLE_EACH = "각 코치는 최대 2개의 못 먹는 메뉴가 있습니다.";
}