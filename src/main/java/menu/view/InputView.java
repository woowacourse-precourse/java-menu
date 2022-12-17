package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static menu.validator.CoachValidator.validateCoach;
import static menu.validator.MenuValidator.validateHateMenu;
import static menu.view.InputConverter.convertToCoach;
import static menu.view.InputConverter.convertToMenu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;

public class InputView {

    public List<Coach> readCoaches() {
        List<String> coachNames = readWordsSeparatedByComma();
        validateCoach(coachNames);
        return convertToCoach(coachNames);
    }

    public List<Menu> readMenus() {
        String input = inputWord();
        if (input.isBlank()) {
            return null;
        }
        List<String> menuNames = separateWordByComma(input);
        validateHateMenu(menuNames);
        return convertToMenu(menuNames);
    }

    private List<String> deleteBlanks(List<String> words) {
        return words.stream().map(String::trim).collect(Collectors.toList());
    }

    private String inputWord() {
        return readLine().trim();
    }

    private List<String> separateWordByComma(String word) {
        List<String> words = Arrays.stream(word.split(","))
                .collect(Collectors.toList());
        return deleteBlanks(words);
    }

    private List<String> readWordsSeparatedByComma() {
        String word = inputWord();
        return separateWordByComma(word);
    }
}
