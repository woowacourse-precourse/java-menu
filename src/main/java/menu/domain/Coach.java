package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    private String name;
    private List<String> prohibitionMenus = new ArrayList<String>();
    private List<String> recommendMenus = new ArrayList<String>();

    public Coach(String name) {
        if (!(2 <= name.length() && name.length() <= 4)) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자 이상 4글자 이하입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return "[ " + name + " | " + recommendMenus.stream().collect(Collectors.joining(" | "))
                + " ]";
    }

    public void setRecommendMenus(Week week) {
        String recommendMenu = Category.recommendRandomMenu(week.getCategory());
        while (isEatable()) {
            recommendMenu = Category.recommendRandomMenu(week.getCategory());
        }
        recommendMenus.add(recommendMenu);
    }

    public boolean isEatable() {
        int prohibitMenuCount = (int) recommendMenus.stream()
                .filter(menu -> prohibitionMenus.contains(menu))
                .count();
        int duplicatedCount = new HashSet<String>(recommendMenus).size();
        return prohibitMenuCount == 0 && duplicatedCount == 5;
    }

    public void setProhibitionMenus(String menus) {
        if (menus.equals("")) {
            return;
        }
        //TODO Category 메뉴에 없는 메뉴일시 올바르게 입력받기
        String[] inputProhibitionMenus = menus.split(",");

        if (!(0 <= inputProhibitionMenus.length && inputProhibitionMenus.length <= 2)) {
            //TODO 0개 입력시 오류
            throw new IllegalArgumentException("[ERROR] 못먹는 메뉴는 0개에서 2개 범위를 넘을 수 없습니다.");
        }
        if (inputProhibitionMenus.length != (new HashSet<String>(List.of(inputProhibitionMenus))).size()) {
            throw new IllegalArgumentException("[ERROR] 중복을 제거해주세요");
        }

        for (String menu : inputProhibitionMenus) {
            prohibitionMenus.add(menu);
        }

    }


}
