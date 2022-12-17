package menu;

public interface ErrorMessage {
    String PREFIX = "[ERROR] ";
    String INVALID_COACH_NAME = "코치의 이름은 최소 2글자, 최대 4글자입니다.";
    String INVALID_COACH_LENGTH ="코치는 최소 2명, 최대 5명과 식사를 합니다.";
    String INVALID_INEDIBLE_EACH = "각 코치는 최대 2개의 못 먹는 메뉴가 있습니다.";
}