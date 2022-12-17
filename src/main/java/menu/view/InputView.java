package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.MenuBoard;
import menu.domain.FoodPeerCoaches;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public FoodPeerCoaches readCoachPeers() {
        try {
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            return new FoodPeerCoaches(makeFoodPeerCoachByConsole());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readCoachPeers();
        }
    }

    public List<Menu> readHateFoodOf(Coach coach) {
        try {
            System.out.println(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coach.getName()));
            return readMenuListByConsole();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readHateFoodOf(coach);
        }

    }

    private List<Coach> makeFoodPeerCoachByConsole() {
        List<String> coachNameDatas = Arrays.asList(Console.readLine().split(","));
        return makeStringListToCoach(coachNameDatas);
    }

    private List<Coach> makeStringListToCoach(List<String> coachList) {
        List<Coach> result = new ArrayList<>();
        for (String coach : coachList) {
            result.add(new Coach(coach));
        }
        return result;
    }

    private List<Menu> readMenuListByConsole() {
        List<String> menuData = Arrays.asList(Console.readLine().split(","));
        return makeStringListToMenu(menuData);
    }

    private List<Menu> makeStringListToMenu(List<String> menuData) {
        List<Menu> result = new ArrayList<>();
        for (String menu : menuData) {
            result.add(MenuBoard.getMenuOf(menu));
        }
        return result;
    }
}
