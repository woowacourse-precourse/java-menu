package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.service.MenuRecommendService;

import java.util.stream.Stream;

public class InputView {
    public static final String INPUT_NAME_MESSAGE = "점심 메뉴 추천을 시작합니다.\n코치의 이름을 입력해 주세요. (, 로 구분)";

    public static String[] inputCoachNames() {
        while (true) {
            System.out.println(INPUT_NAME_MESSAGE);
            try {
                String[] coachNames = getValidCoachNames();
                System.out.println();
                return coachNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String[] getValidCoachNames() throws IllegalArgumentException {
        String[] coachNames = Console.readLine().split(",");
        if (coachNames.length < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (coachNames.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최대 5명 입력해야 합니다.");
        }
        if (Stream.of(coachNames).anyMatch((coachName) -> coachName.length() < 2 || coachName.length() > 4)) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2~4글자이어야 합니다.");
        }
        return coachNames;
    }

    public static String[] inputBannedMenu(String coachName) {
        while (true) {
            System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
            try {
                String[] bannedMenu = getValidBannedMenu();
                System.out.println();
                return bannedMenu;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String[] getValidBannedMenu() {
        String bannedSentence = Console.readLine();
        if (bannedSentence.length() == 0) { // 공백 입력시 null리턴
            return null;
        }
        String[] bannedMenu = bannedSentence.split(",");
        if (bannedMenu.length > 2) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 최대 2개까지 입력 가능합니다.");
        }
        if (Stream.of(bannedMenu).anyMatch((menu) -> !MenuRecommendService.isValidMenu(menu))) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴가 있습니다.");
        }
        return bannedMenu;
    }
}
