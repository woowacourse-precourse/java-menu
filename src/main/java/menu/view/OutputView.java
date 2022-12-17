package menu.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printResult(List<String> categories, List<List<String>> coachesMenus, List<String> coachesNames) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(makeCategoryString(categories));
        System.out.println(makeMenusString(coachesMenus, coachesNames));
        System.out.println("추천을 완료했습니다.");
    }

    private String makeCategoryString(List<String> categories) {
        String joined = categories.stream()
                .collect(Collectors.joining(" | "));

        return "[ 카테고리 | " + joined + " ]";
    }

    private String makeMenusString(List<List<String>> coachesMenus, List<String> coachesNames) {
        StringBuilder menuString = new StringBuilder();
        for (int i = 0; i < coachesNames.size(); i++) {
            String prefix = "[ " + coachesNames.get(i) + " | ";
            String joined = String.join(" | ", coachesMenus.get(i));
            menuString.append(prefix + joined + " ]\n");
        }

        return menuString.toString();
    }
}
