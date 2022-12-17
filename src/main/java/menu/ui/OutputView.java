package menu.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.constant.Day;
import menu.domain.vo.CoachMenu;

public class OutputView {

    public void announceStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        addEmptyLine();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        addEmptyLine();
    }

    private void addEmptyLine() {
        System.out.println();
    }

    public void printTopOfTable(List<String> categoriesOfWeek) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | " + String.join(" | ", Arrays.stream(Day.values()).map(Day::getDayInKorean).collect(
                Collectors.toList())) + " ]");
        System.out.println("[ 카테고리 | " + String.join(" | ", categoriesOfWeek) + " ]");
    }

    public void printMenuRecommendResult(List<CoachMenu> coachMenus) {
        coachMenus.forEach(coachMenu -> {
            System.out.println(
                    "[ " + coachMenu.getCoachName() + " | " + String.join(" | ", coachMenu.getMenus()) + " ]");
        });
        addEmptyLine();
        System.out.print("추천을 완료했습니다.");
    }
}
