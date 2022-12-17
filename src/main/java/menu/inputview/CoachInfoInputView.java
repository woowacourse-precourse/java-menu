package menu.inputview;

import menu.domain.Coach;
import menu.domain.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoachInfoInputView extends AbstractInputView {

    public static List<Coach> getCoaches() {
        String coachNamesInput = readInput();
        return Converter.toCoaches(coachNamesInput);
    }

    public static List<Menu> getMenusBanned() {
        String bannedMenusInput = readInput();
        return Converter.toMenus(bannedMenusInput);
    }

    private static class Converter {

        public static final String COMMA = ",";

        public static List<Coach> toCoaches(String coachNamesInput) {
            String[] coachNames = splitSentenceByComma(coachNamesInput);
            return Arrays.stream(coachNames)
                    .map(Coach::new)
                    .collect(Collectors.toList());
        }

        public static List<Menu> toMenus(String bannedMenusInput) {
            String[] bannedMenus = splitSentenceByComma(bannedMenusInput);
            return Arrays.stream(bannedMenus)
                    .map(Menu::new)
                    .collect(Collectors.toList());
        }

        private static String[] splitSentenceByComma(String coachNamesInput) {
            return coachNamesInput.split(COMMA);
        }
    }
}
