package menu.view;

import menu.Constant;
import menu.dto.CoachWeekMenu;
import menu.enums.FoodCategory;

import java.util.List;

public class OutputView {

    public void printMenuResult(List<FoodCategory> weekCategory, List<CoachWeekMenu> coachWeekMenus) {
        System.out.println(Constant.outputRecommendFoodResult);
        System.out.println(Constant.outputRecommendFoodResultWeek);
        printCategory(weekCategory);
        printCoachMenu(coachWeekMenus);
    }

    private void printCoachMenu(List<CoachWeekMenu> coachWeekMenu) {
        for(CoachWeekMenu coachMenu : coachWeekMenu) {
            System.out.print(Constant.outputRecommendFoodResultStart
                    + coachMenu.getCoach().getName()
                    + Constant.outputRecommendFoodResultCenter);
            printEachMenu(coachMenu);
        }
    }

    private void printEachMenu(CoachWeekMenu coachWeekMenu) {
        for (int i = 0; i < coachWeekMenu.getEatMenus().size(); i++) {
            if (i == coachWeekMenu.getEatMenus().size()-1) {
                System.out.println(coachWeekMenu.getEatMenus().get(i)
                        +Constant.outputRecommendFoodResultEnd);
                break;
            }
            System.out.print(coachWeekMenu.getEatMenus().get(i)
                    + Constant.outputRecommendFoodResultCenter);
        }
    }

    private void printCategory(List<FoodCategory> weekCategory) {
        System.out.print(Constant.outputRecommendFoodResultCategory);
        for (int i = 0 ; i < weekCategory.size(); i++) {
            if (i == weekCategory.size()-1) {
                System.out.println(weekCategory.get(i).label()
                        +Constant.outputRecommendFoodResultEnd);
                break;
            }
            System.out.print(weekCategory.get(i).label() + " | ");
        }
    }
}
