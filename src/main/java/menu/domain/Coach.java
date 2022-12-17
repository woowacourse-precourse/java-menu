package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {

    private static final int NAME_MAX_LENGTH = 4;
    private static final int NAME_MIN_LENGTH = 2;
    private static final int HATE_MENU_MAX_SIZE = 2;

    private final String name;
    private final List<String> hateMenus;
    private final List<String> lunchMenus = new ArrayList<>();

    public Coach(String name,
                 List<String> hateMenus) {
        validateName(name);
        validateHateMenus(hateMenus);
        this.name = name;
        this.hateMenus = new ArrayList<>(hateMenus);
    }

    public void addLunchMenu(Category category) {
        while (true) {
            String randomMenu = category.createRandomMenu();
            if (!isHateOrDuplicateMenu(randomMenu)) {
                lunchMenus.add(randomMenu);
                break;
            }
        }
    }

    public List<String> getLunchMenus() {
        return Collections.unmodifiableList(lunchMenus);
    }

    public String getName() {
        return name;
    }

    private void validateHateMenus(List<String> hateMenus) {
        if (hateMenus.size() > HATE_MENU_MAX_SIZE) {
            throw new IllegalArgumentException("코치가 못먹는 메뉴는 최대 2개입니다. 추가할려는 메뉴 갯수  : " +
                    hateMenus.size());
        }

        if (hateMenus.stream().distinct().count() != hateMenus.size()) {
            throw new IllegalArgumentException("중복된 메뉴가 존재합니다.");
        }
    }

    private void validateName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다. 입력값 : " + name);
        }
    }

    private boolean isHateOrDuplicateMenu(String menu) {
        return isHateMenu(menu) || duplicateLunchMenu(menu);
    }

    private boolean isHateMenu(String menu) {
        return hateMenus.contains(menu);
    }

    private boolean duplicateLunchMenu(String menu) {
        return lunchMenus.contains(menu);
    }
}
