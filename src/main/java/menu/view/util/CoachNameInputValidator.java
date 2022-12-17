package menu.view.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoachNameInputValidator {
        private final String regex = "[0-9a-zA-Zㄱ-ㅎ가-힣]{2,4}";
        private final String lessCoachErrorMessage = "코치는 최소 2명 이상 입력해야 합니다.";
        private final String wrongFormatErrorMessage = "올바른 형식으로 입력해주세요";
        private final int MIN_COACH = 2;
        private final Pattern pattern = Pattern.compile(regex);

        public void validate(String ... names){
            if(names.length < MIN_COACH){
                throw new IllegalArgumentException(lessCoachErrorMessage);
            }
            for(String name : names){
                Matcher matcher = pattern.matcher(name.trim());
                if (!matcher.matches()){
                    throw new IllegalArgumentException(wrongFormatErrorMessage);
                }
            }
        }

    public static void main(String[] args) {
        CoachNameInputValidator validator = new CoachNameInputValidator();
        try {
            validator.validate("가나다","가나다");
            validator.validate("가나다","가나다","라마바");
        }catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
        }
    }

}
