package menu.model;

import menu.util.ErrorMessage;

import java.util.*;

public class Coach {

    private static final int DAYS = 5;
    private String name;
    private List<Menu> nonMenus;

    private Map<Category, Integer> recommendCategory;
    private List<Menu> recommendMenu;

    public Coach(String name) {
        validateNameSize(name);
        this.name = name;
        recommendCategory = new HashMap<>();
        recommendMenu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Menu> getRecommendMenu() {
        return recommendMenu;
    }

    public void setNonMenus(List<Menu> nonMenus) {
        this.nonMenus = nonMenus;
    }



    /**
     * 추천 메뉴 추가
     */
    public void addRecommendMenu(Menu menu){
        recommendMenu.add(menu);
    }

    /**
     * 월화수목금 추천 됐는지 확인 기능
     */
    public boolean isStop() {
        return recommendMenu.size() != DAYS;
    }

    /**
     * 메뉴 제한 확인 메서드
     */
    public boolean isFineEatMenu(Menu menu) {
        return !recommendMenu.contains(menu);
    }

    /**
     * 카테고리 제한 확인 메서드
     */
    public void countCategory(Category category) {
        if(!recommendCategory.containsKey(category)){
            recommendCategory.put(category, 1);
        }
        if(recommendCategory.containsKey(category)){
            int count = recommendCategory.get(category);
            recommendCategory.put(category, count + 1);
        }
    }

    public boolean isFineCategory(Category category) {
        if(recommendCategory.size()!=0) {
            int count = recommendCategory.get(category);
            return count > 2;
        }
        return true;
    }


    /**
     * Coach 이름 예외사항 체크
     */
    public void validateNameSize(String name) {
        if (isCorrectNameSize(name)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NAME_SIZE_OVER_ERROR_MESSAGE.getMessage());
    }

    private static boolean isCorrectNameSize(String name) {
        return name.length() >= 2 && name.length() <= 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach)) return false;

        Coach coach = (Coach) o;

        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", nonMenus=" + nonMenus +
                ", recommendCategory=" + recommendCategory +
                ", recommendMenu=" + recommendMenu +
                '}';
    }
}
