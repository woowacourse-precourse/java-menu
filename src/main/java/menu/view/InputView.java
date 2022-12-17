package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import static menu.constatnts.Constants.*;

public class InputView {

    public List<String> scanCoachNames() {
        System.out.println();
        System.out.println(SCAN_COACH_NAMES_MSG);
        List<String> names;
        try {
            names = Arrays.asList(Console.readLine().split(SPLITTER_INPUT));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_SPLITTER);
        }
        return validateNames(names);
    }

    public List<String> validateNames(List<String> names) {
        if (names.size() < COACH_NUMS_MIN || COACH_NUMS_MAX < names.size()) {
            throw new IllegalArgumentException(ERROR_COACH_NUMS);
        }

        for (String name : names) {
            if (name.length() < COACH_NAMES_LENGTH_MIN || COACH_NAMES_LENGTH_MAX < name.length()) {
                throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH);
            }
        }
        return names;
    }

    public List<String> scanHatesFood(String name) {
        System.out.println();
        System.out.printf(SCAN_COACH_HATES_FOOD_MSG, name);
        List<String> hates;
        try {
            hates = Arrays.asList(Console.readLine().split(SPLITTER_INPUT));
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_COACH_FOODS_SPLITTER);
        }
        return validateHatesFood(hates);
    }

    public List<String> validateHatesFood(List<String> hates) {

        if (COACH_HATE_FOOD_MAX < hates.size()) {
            throw new IllegalArgumentException(ERROR_COACH_HEATED_FOOD_MANY);
        }
        //싫어 하는게 없는 경우
        if (hates.equals(List.of(""))) {
            return new ArrayList<>();
        }
        return hates;
    }
}
