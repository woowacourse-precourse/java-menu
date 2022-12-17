package menu.view;

import java.util.List;

import menu.utils.constants.OutputMessage;

public class OutputView {
    public static OutputView instance = new OutputView();

    public static OutputView getInstance(){
        return instance;
    }

    public void printStartMessage(){
        System.out.println(OutputMessage.RECOMMENDATION_START.getMessage());
    }

    public void printRecommendInfo(){
        System.out.println(OutputMessage.RESULT_SHOW_MESSAGE.getMessage());
        System.out.println(OutputMessage.DAYS_MESSAGE.getMessage());
    }

    public void printCategoryResult(List<String> categories){
        StringBuilder result = new StringBuilder(OutputMessage.CATEGORY_MESSAGE.getMessage());

        for(String category: categories){
            result.append(OutputMessage.DIVISION_SHAPE.getMessage());
            result.append(category);
        }

        result.append(OutputMessage.END_SHAPE.getMessage());

        System.out.println(result);
    }

    public void printRecommendResult(String name, List<String> foods){
        StringBuilder result = new StringBuilder(OutputMessage.START_SHAPE.getMessage() + name);

        for(String food : foods){
            result.append(OutputMessage.DIVISION_SHAPE.getMessage());
            result.append(food);
        }

        result.append(OutputMessage.END_SHAPE.getMessage());

        System.out.println(result);
    }

    public void printGoodBye(){
        System.out.println(OutputMessage.GOODBYE_MESSAGE.getMessage());
    }


}
