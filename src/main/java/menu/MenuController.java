package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Couch;
import menu.domain.DataRow;
import menu.domain.DataRows;
import menu.domain.Day;
import menu.domain.Menu;

public class MenuController {

    private static final DataRow DIV_ROW = new DataRow("구분",
            Arrays.stream(Day.values()).map((day) -> day.getName()).collect(Collectors.toUnmodifiableList()));
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void initData() {
        for (DummyData data : DummyData.values()) {
            data.getMenuNames().forEach((menuName) -> MenuRepository.addMenu(new Menu(data.getCategory(), menuName)));
        }

    }

    public void operate() {
        initData();

        outputView.printStartComment();

        List<String> couchNames = getCouchNames();
        List<Couch> couches = createCouches(couchNames);

        outputView.printRecommendResult(recommendMenus(couches));
    }

    public DataRows recommendMenus(List<Couch> couches) {
        Map<Couch, List<Menu>> couchMenus = new LinkedHashMap<>();
        List<String> categories = new ArrayList<>();

        for (Day day : Day.values()) {
            List<Menu> menuOfDay = recommendMenuForDay(couches);
            categories.add(menuOfDay.get(0).getCategory().getName());

            for (int i = 0; i < couches.size(); i++) {
                List<Menu> menuForCouch = couchMenus.getOrDefault(couches.get(i), new ArrayList<>());
                menuForCouch.add(menuOfDay.get(i));
                couchMenus.put(couches.get(i), menuForCouch);
            }
        }

        List<DataRow> resultRows = new ArrayList<>(List.of(DIV_ROW, new DataRow("카테고리", categories)));

        resultRows.addAll(couchMenus.keySet().stream().map((couch) -> new DataRow(couch.getName(),
                        couchMenus.get(couch).stream().map((menu) -> menu.getName()).collect(Collectors.toUnmodifiableList())))
                .collect(Collectors.toUnmodifiableList()));

        return new DataRows(resultRows);
    }

    public List<Menu> recommendMenuForDay(List<Couch> couches) {
        Category category = getAbleCategory(couches);

        List<Menu> recommendedMenu = couches.stream()
                .map((couch) -> recommendMenuForCouch(couch, MenuRepository.getMenusByCategory(category).stream().map((menu) -> menu.getName()).collect(
                        Collectors.toList())))
                .collect(Collectors.toUnmodifiableList());

        for (int i = 0; i < couches.size(); i++) {
            couches.get(i).addDisableMenu(recommendedMenu.get(i));
        }

        return recommendedMenu;
    }

    private Category getAbleCategory(List<Couch> couches) {
        Category selected;
        do {
            selected = Category.getMatchCategory(Randoms.pickNumberInRange(1, 5));
        } while (isDisableCategory(selected, couches));

        return selected;
    }

    private boolean isDisableCategory(Category category, List<Couch> couches) {
        return couches.stream()
                .anyMatch((couch) -> couch.getAbleMenus(MenuRepository.getMenusByCategory(category)).size() == 0);
    }

    public Menu recommendMenuForCouch(Couch couch, List<String> menus) {
        Menu selectedMenu;
        do {
            selectedMenu = MenuRepository.getMenusByName(Randoms.shuffle(menus).get(0));
        } while (couch.isAlreadyRecommended(selectedMenu));

        return selectedMenu;
    }


    public List<Couch> createCouches(List<String> couchNames) {
        return couchNames.stream().map((couchName) -> new Couch(couchName,
                getDisableMenuNames(couchName).stream().map((menuName) -> MenuRepository.getMenusByName(menuName))
                        .collect(Collectors.toList()))).collect(Collectors.toUnmodifiableList());
    }

    public List<String> getCouchNames() {
        while (true) {
            try {
                return Validator.validateCouches(inputView.getCouchNames());
            } catch (Exception e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public List<String> getDisableMenuNames(String couchName) {
        while (true) {
            try {
                return Validator.validateMenus(inputView.getCannotEatMenuNames(couchName));
            } catch (Exception e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
