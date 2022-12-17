package menu.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Names {
    private final String INVALID_SIGN = "[ERROR] ,를 이용하여 이름을 구분하여 주세요";
    private final String INVALID_LENGTH = "[ERROR] 글자의 길이는 2글자에서 4글자 사이입니다.";
    private final String INVALID_FORM = "[ERROR] 이름 중복이 불가능합니다.";
    private final String INVALID_NAME_OVERLAP = "[ERROR] 글자는 한글만 가능합니다.";
    private final String NAME_FORM = "^[가-힣]+$";
    private final String SEPARATOR = ",";
    private final int MIN_NUMBER = 2;
    private final int MAX_NUMBER = 4;
    private List<String> names;

    public Names(String names) {
        validateForm(names);
        this.names = Arrays.asList(names.split(SEPARATOR));
    }

    private void validateForm(String names) {
        validateSign(names);
        List<String> target = Arrays.asList(names.split(SEPARATOR));
        validateNames(target);
        validateOverLap(target);
    }

    private void validateSign(String names) {
        if (!names.contains(SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_SIGN);
        }
    }

    private void validateNames(List<String> target) {
        target.stream().
                forEach(name -> {
                    validateNameLength(name);
                    validateNameForm(name);
                });
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NUMBER || name.length() > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }

    private void validateNameForm(String name) {
        if (!name.matches(NAME_FORM)) {
            throw new IllegalArgumentException(INVALID_FORM);
        }
    }

    private void validateOverLap(List<String> names) {
        Set tempSet = new HashSet<>(names);
        if (tempSet.size() != names.size()) {
            throw new IllegalArgumentException(INVALID_NAME_OVERLAP);
        }
    }

    public List<String> getNames() {
        return this.names;
    }

}
