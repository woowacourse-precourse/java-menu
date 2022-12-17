package menu.exception;

public enum ExceptionMassage {
    COACH_CNT_ERROR("2명이상 5명 이하의 코치를 입력해야합니다"),
    COACH_NAME_LENGTH_ERROR("코치의 글자수는 2 이상 4이하 입니다."),
    SAME_NAME_EXCEPTION("서로 다른 이름을 입력하시오.");
    String error;
    ExceptionMassage(String error){
        this.error ="[ERROR] " +   error;
    }
    public String getError(){return this.error;}
}
