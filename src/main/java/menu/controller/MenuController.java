package menu.controller;

import static menu.utils.constant.MAX_DUPLICATE_CATEGORY;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final Category category;
    private List<String> recomandedCategory;
    private List<Coach> coaches;

    public MenuController() {
        this.category = new Category();
        this.recomandedCategory = new ArrayList<>();
        coaches = new ArrayList<>();
    }

    public void start() {
        try {
            OutputView.printStart();
            boolean keep = true;
            while (keep) {
                readCoach();
                readDislikeMenu();
                randomSelect();
                System.out.println("finish?");
                OutputView.printResult(recomandedCategory, coaches);
                keep = false;
            }
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private void readCoach() {
        try {
            String[] input = InputView.readCoachName();
            for (String coach : input) {
                coaches.add(new Coach(coach));
            }
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            readCoach();
        }
    }

    private void readDislikeMenu() { // 싫어하는 메뉴 기존 메뉴에서 검증할거면 이 형태!!
        for (Coach coach : coaches) {
            readMenu(coach);
        }
    }

    private void readMenu(Coach coach) {
        try {
            String[] input = InputView.readDislikeMenu(coach.getName());
            coach.addDislikeMenu(input);

        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            readMenu(coach);
        }
    }

    private void randomSelect() {
        List<String> days = Day.getDayValueList();
        List<String> menus = new ArrayList<>();
        for (String day : days) {
            selectCategory();
            selectMenu();
        }
    }

    private void selectCategory() {
        boolean flag = true;
        String randomCategory = "";
        while (flag) {
            randomCategory = category.get(Randoms.pickNumberInRange(1, 5));
            int count = Collections.frequency(recomandedCategory, randomCategory);
            if (count < MAX_DUPLICATE_CATEGORY) {
                flag = false;
            }
        }
        recomandedCategory.add(randomCategory);
    }

    private void selectMenu() {
        for (Coach coach : coaches) {
            for (String recommandCategory : recomandedCategory) {
                checkToCoach(coach, recommandCategory);
                if (coach.getRecomandedMenu().size() == 5) {
                    break;
                }
            }
        }
    }

    private void checkToCoach(Coach coach, String recommandCategory) {
        boolean flag = true;
        List<String> recommandMenu = new ArrayList<>();
        while (flag) {
            final List<String> menuPerCategory = new ArrayList<>();
            menuPerCategory.addAll(category.getMenu(recommandCategory));
//                    category.getMenu(recommandCategory);
            //메뉴 뽑기
            // 뽑은 추천메뉴와 싫은메뉴 전달해서 코치의 진짜 추천메뉴에 추가

            isCorrect(coach, getRandomMenu(coach, menuPerCategory), recommandMenu);
            if (coach.getRecomandedMenu().size() == 5) {
                flag = false;
            }
        }
    }

    private void isCorrect(Coach coach, String menu, List<String> recommandMenu) {
        if (recommandMenu.contains(menu)) {
            return ;
        }
        List<String> dislike = coach.getDislikeMenu();
        if (dislike.contains(menu)) {
            return;
        }
        recommandMenu.add(menu);
        coach.getRecomandedMenu().add(menu);
    }

    private String getRandomMenu(Coach coach, List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        menus.add(menu);
        return menu;
    }

}