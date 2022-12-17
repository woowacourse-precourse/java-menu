package menu.output;

import menu.domain.Category;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {
    public void GAME_START_OUTPUT() {
        System.out.println(OutputString.GAME_START_OUTPUT);
    }

    public void format(List<String> lists, String prefix) {
        StringBuilder sb = new StringBuilder("[ " + prefix + " ");

        for (String list : lists) {
            sb.append("| " + list + " ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void format(Set<String> lists, String prefix) {
        StringBuilder sb = new StringBuilder("[ " + prefix + " ");

        for (String list : lists) {
            sb.append("| " + list + " ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void PRINT_RESULT(List<Category> categories, Map<String, Set<String>> coaches) {
        List<String> day = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일");
        List<String> categoryList = categories.stream().map(c -> c.getCategory()).collect(Collectors.toList());

        System.out.println(OutputString.MENU_RESULT);
        format(day, OutputString.SPLITTER);
        format(categoryList, OutputString.CATEGORY);
        for (String coachName : coaches.keySet()) {
            Set<String> candidateMenu = coaches.get(coachName);
            format(candidateMenu, coachName);
        }
        System.out.println();
        System.out.println(OutputString.COMP);
    }
}
