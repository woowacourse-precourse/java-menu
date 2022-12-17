package menu.view;

public enum ErrorMessage {
  COACH_NAME_SIZE_ERROR("코치의 이름은 최소 2글자, 최대 4글자 이어야 합니다."),
  CANNOT_EAT_SIZE_ERROR("코치가 못먹는 음식은 2개 이하 입니다.");
  public String getMessage() {
    return message;
  }

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }
}
