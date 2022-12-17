package menu;

import camp.nextstep.edu.missionutils.Console;
import menu.service.MenuRecommendService;

public class Application {
    public static void main(String[] args) {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String coachNames = Console.readLine();
        System.out.println();
        for (String coachName : coachNames.split(",")) {
            System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
            String bannedMenus = Console.readLine().strip();
            System.out.println();
            if (bannedMenus.length() == 0) {
                continue;
            }
            for (String bannedMenu : bannedMenus.split(",")) {
                MenuRecommendService.addBannedMenu(coachName, bannedMenu);
            }
        }
    }
}
