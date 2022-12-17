package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.validator.ErrorMessages;
import menu.view.InputView;
import menu.view.OutputView;

public class Service {

    private final List<Menu> menus = new ArrayList();

    public List<Category> getCategories() {
        return categories;
    }

    private final List<Category> categories = new ArrayList<>();
    private final List<Coach> group = new ArrayList();
    private final List<Day> daysResult = new ArrayList<>();

    public void start() {
        OutputView.start();
        initAll();
    }

    public void initAll() {
        initCategories();
        initMenus();
    }

    public void initCategories() {
        for (ValidCategories category : ValidCategories.values()) {
            categories.add(new Category(category));
        }
    }

    public Category findCategoryByName(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return category;
            }
        }
        throw new IllegalArgumentException(ErrorMessages.ERROR.toString() + "없는 카테고리 입니다.");
    }

    public void initMenus() {
        for (ValidMenus menu : ValidMenus.values()) {
            menus.add(new Menu(this, menu));
        }
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
        addMenu(new Menu(this, ValidMenus.findMenuByName(name)));
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
                Category categoryByName = findCategoryByName(
                    ValidCategories.getCategoryByNumber(categoryNumber).getKorean());
                daysResult.add(new Day(dayName.getKorean(), categoryByName));
                return;
            }
            categoryNumber = Randoms.pickNumberInRange(1, 5);
        }
    }

    public static boolean isAbleCategory(List<Day> days, ValidCategories category) {
        int count = 0;
        for (Day day : days) {
            if (day.getCategory().getMenus().equals(category.getKorean())) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return true;
    }

    public void recommendMenu() {
        for (Day day : daysResult) {
            recommendToCoach(day.getCategory());
        }
    }

    public void recommendToCoach(Category category) {
        for (Coach coach : group) {
            fixRecommend(coach, category);
        }
    }

    public Menu findMenuByName(String name) {
        for (Menu menu : menus) {
            if(menu.getName().equals(name)){
                return menu;
            }
        }
        return null;
    }

    public void fixRecommend(Coach coach, Category category) {
        while (true) {
            List<String> shuffle = Randoms.shuffle(category.getMenuNames());
            Menu recommendMenu = findMenuByName(shuffle.get(0));
            if (!coach.isHate(recommendMenu) || coach.getRecommended().contains(recommendMenu)) {
                coach.addRecommend(recommendMenu);
                break;
            }
        }
    }

    public void showResult() {
        OutputView.showDays();
        OutputView.showCategories(this);
        OutputView.showRecommended(this);
    }

    public List<Day> getDaysResult() {
        return daysResult;
    }

    public List<Coach> getGroup() {
        return group;
    }
}
