package menu.domain;

import menu.service.constant.WeekDay;
import menu.view.util.constant.ResultSymbol;

import java.util.List;
import java.util.StringJoiner;

public class ResultConverter {

    public String convertToCoachResult(String coachName, List<String> randomFoods){
        StringJoiner joiner = new StringJoiner(ResultSymbol.DELIMITER,ResultSymbol.PREFIX, ResultSymbol.SUFFIX);
        joiner.add(coachName);
        for(String food : randomFoods){
            joiner.add(food);
        }
        return joiner.toString();
    }
    public String convertToWeekResult(List<Category> weekList){
        StringJoiner joiner = new StringJoiner(ResultSymbol.DELIMITER,ResultSymbol.PREFIX, ResultSymbol.SUFFIX);
        joiner.add("카테고리");
        for(Category category : weekList){
            joiner.add(category.getName());
        }
        return joiner.toString();
    }
    public String convertToResultBar(){
        StringJoiner joiner = new StringJoiner(ResultSymbol.DELIMITER,ResultSymbol.PREFIX, ResultSymbol.SUFFIX);
        joiner.add("구분");
        joiner.add(WeekDay.MON.getName());
        joiner.add(WeekDay.TUE.getName());
        joiner.add(WeekDay.WED.getName());
        joiner.add(WeekDay.THU.getName());
        joiner.add(WeekDay.FRI.getName());
        return joiner.toString();
    }

    public static void main(String[] args) {
        ResultConverter converter = new ResultConverter();
        System.out.println(converter.convertToResultBar());
    }
}
