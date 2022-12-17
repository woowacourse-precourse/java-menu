package menu.view;

public enum OutputMessage {


  INPUT_COACHES_MESSAGE("\n코치의 이름을 입력해 주세요. (, 로 구분)"),

  COACHES_SIZE_ERROR("코치는 2명 이상 5명 이하로 식사를 합니다."),

  CANNOT_EAT("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.");

  public String getMessage() {
    return message;
  }

  private final String message;

  OutputMessage(String message) {
    this.message = message;
  }

}
