package menu.domain;

public class Coach {
    private final String name;
    private final Menus noEat;
    private final Menus eaten;

    public Coach(String name, Menus noEat) {
        validate(name);
        this.name = name;
        this.noEat = noEat;
        this.eaten = new Menus();
    }

    private void validate(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("이름 형식 에러");
        }
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("이름 길이 에러");
        }
    }

    public void receiveRecommendation(Menus allMenus, Category category, RecommendationMachine recommendationMachine) {
        Menus notAllowed = noEat.combine(eaten);
        eaten.add(recommendationMachine.menu(allMenus, category, notAllowed));
    }
}
