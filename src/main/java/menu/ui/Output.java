package menu.ui;

import java.util.List;
import menu.constans.Message;
import menu.domain.Category;
import menu.domain.Coach;

public class Output {
    public void printStartMessage() {
        System.out.println(Message.START.getMessage());
    }

    public void printRequestCoachNames() {
        System.out.println(Message.REQUEST_COUCH_NAME.getMessage());
    }

    public void printRequestCoachCantEatFood(String coachName) {
        System.out.println();
        System.out.println(coachName+Message.REQUEST_FOODS_CANT_EAT.getMessage());
    }

    public void printRecommendResult(List<Coach> coaches, List<Category> categories) {
        System.out.println();
        System.out.println(Message.RESULT.getMessage());
        System.out.println(Message.RESULT_TEMPLATE.getMessage());
//        System.out.printf("[ 카테고리 | %s | %s | %s | %s | %s ]\n",categories.get(0).getName(),categories.get(1).getName(),categories.get(2).getName(),categories.get(3).getName(),categories.get(4).getName());
        System.out.println("[ 카테고리 | "+categories.get(0).getName()+" | "+categories.get(1).getName()+" | "+categories.get(2).getName()+" | "+categories.get(3).getName()+" | "+categories.get(4).getName()+" ]");
        for (Coach coach : coaches) {
            System.out.printf("[ %s | %s | %s | %s | %s | %s ]\n",coach.getName(),coach.getRecommendFood().get(0),coach.getRecommendFood().get(1),coach.getRecommendFood().get(2),coach.getRecommendFood().get(3),coach.getRecommendFood().get(4));
        }

    }

    public void printEndMessage() {
        System.out.println();
        System.out.println(Message.COMPLETION.getMessage());
    }
}

