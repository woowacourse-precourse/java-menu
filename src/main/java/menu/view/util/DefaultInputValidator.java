package menu.view.util;

public class DefaultInputValidator {
    public void validateBlank(String input){
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값 입력은 불가능합니다.");
        }
    }
    public void validateSeparator(String input){
        if(input.matches("[^,]")){
            throw new IllegalArgumentException("올바른 구분자를 사용해주세요.");
        }
    }
}
