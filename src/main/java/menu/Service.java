package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.view.InputView;
import menu.view.OutputView;

public class Service {

    private static final List<Coach> group = new ArrayList();
    private static final List<Menu> menus = new ArrayList();
    private static final List<Day> daysResult = new ArrayList<>();

    public void start() {
        OutputView.start();
    }

    public void getCoach() {
        while (true) {
            try {
                OutputView.insertCoaches();
                InputView.insertCoach(this);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getHateMenus() {
        group.forEach(coach -> {
            getHateMenuByCoach(coach);
        });
    }

    public void getHateMenuByCoach(Coach coach) {
        while (true) {
            try {
                OutputView.insertHateMenuBy(coach);
                InputView.insertHateMenuBy(this, coach);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addCoach(Coach coach) {
        group.add(coach);
    }

    public void addMenu(Menu menu) {
        if (!menus.contains(menu)) {
            menus.add(menu);
        }
    }

    public void addHateMenuBy(Coach coach, Menu menu) {
        coach.addHateMenu(menu);
    }

    public Menu getMenuByName(String name) {
        for (Menu menu : menus) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        addMenu(new Menu(ValidMenus.findMenuByName(name)));
        return null;
    }

    public void initDays() {
        for (DaysName dayName : DaysName.values()) {
            initDay(dayName);
        }
    }

    public void initDay(DaysName dayName) {
        int categoryNumber = Randoms.pickNumberInRange(1, 5);
        while (true) {
            if (isAbleCategory(daysResult, ValidCategories.getCategoryByNumber(categoryNumber))) {
                daysResult.add(new Day(dayName.getKorean(), ValidCategories.getCategoryByNumber(categoryNumber)));
                return;
            }
            categoryNumber = Randoms.pickNumberInRange(1, 5);
        }
    }

    public static boolean isAbleCategory(List<Day> days, ValidCategories category) {
        int count = 0;
        for (Day day : days) {
            if (day.getCategoryName().equals(category.getKorean())) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return true;
    }
}
