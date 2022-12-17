package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private static final String MESSAGE_START = "점심 메뉴 추천을 시작합니다.\n";
    private static final String MESSAGE_END = "추천을 완료했습니다.";
    private MenuRepository menuListFull = new MenuRepository();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void start() {
        outputView.printMessage(MESSAGE_START);

        List<String> coachsName = inputView.readCoachName();
        List<String> menuList = new ArrayList<>();
        List<List<String>> coachMenuList = new ArrayList<>();

        List<String> weekCategory = new ArrayList<>();

        for (int i = 0; i< coachsName.size(); i++) {
            inputView.readNotEatMenu(coachsName.get(i));
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            Category category = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
            weekCategory.add(category.getName());
        }
        for (int i = 0; i < coachsName.size(); i++) {
            menuList.clear();
            for (int j = 0; j < 5; j++) {
                List<String> menus = menuListFull.findCategoryMenu(weekCategory.get(j));
                menuList.add(Randoms.shuffle(menus).get(0));
            }
            coachMenuList.add(menuList);
        }

        outputView.printResult(weekCategory, coachsName, coachMenuList);
        outputView.printMessage(MESSAGE_END);
    }



}
