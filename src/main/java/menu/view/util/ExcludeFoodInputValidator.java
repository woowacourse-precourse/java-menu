package menu.view.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcludeFoodInputValidator {
//    private final String regex = "[0-9a-zA-Zㄱ-ㅎ가-힣]{2,4}";
    private final String tooMuchErrorMessage = "못먹는 음식은 2개까지 입력해주세요";
//    private final String wrongFormatErrorMessage = "올바른 형식으로 입력해주세요";
    private final int MAX_VALUE = 2;
//    private final Pattern pattern = Pattern.compile(regex);

//        public CoachNameInputValidator(){
//            this.regex = regex;
//            this.errorMessage = errorMessage;
//            this.pattern = complie(regex);
//        }

    public void validate(String ... foods){
        if(foods.length > MAX_VALUE){
            throw new IllegalArgumentException(tooMuchErrorMessage);
        }
//        for(String food : foods){
//            Matcher matcher = pattern.matcher(food);
//            if (!matcher.matches()){
//                throw new IllegalArgumentException(wrongFormatErrorMessage);
//            }
//        }
    }
}
