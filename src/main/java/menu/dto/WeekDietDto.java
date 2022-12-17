package menu.dto;

import menu.domain.Coach;
import menu.domain.FoodCategory;
import menu.domain.Week;
import menu.domain.WeekDiet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeekDietDto {

    private List<Week> weeks;
    private List<FoodCategory> weekFoodCategories;
    private Map<Coach,List<String>> weekDietByCoachs;

    private WeekDietDto(List<Week> weeks
            , List<FoodCategory> weekFoodCategories
            , Map<Coach, List<String>> weekDietByCoachs) {
        this.weeks = weeks;
        this.weekFoodCategories = weekFoodCategories;
        this.weekDietByCoachs = weekDietByCoachs;
    }

    public static WeekDietDto from(WeekDiet weekDiet){
        return new WeekDietDto(weekDiet.getWeeks()
                ,weekDiet.getWeekFoodCategories()
                ,weekDiet.getWeekDietByCoachs());
    }

    @Override
    public String toString(){
        return toStringWeeks()+"\n"+toStringWeekFoodCategories()+"\n"+toStringWeekDietByCoachs();
    }

    private String toStringWeeks(){
        String pureStringOfWeeks = weeks.toString()
                .replace("[","")
                .replace("]","");

        return Arrays.stream(pureStringOfWeeks.split(","))
                .collect(Collectors.joining(" |","[ 구분 | "," ]"));
    }

    private String toStringWeekFoodCategories(){
        String pureStringOfWeeks = weekFoodCategories.toString()
                .replace("[","")
                .replace("]","");

        return Arrays.stream(pureStringOfWeeks.split(","))
                .collect(
                        Collectors.joining(" |","[ 카테고리 | "," ]")
                );
    }

    private String toStringWeekDietByCoachs(){
        StringBuffer result = new StringBuffer();
        for(Coach coach : weekDietByCoachs.keySet()){
            result.append(weekDietByCoachs.get(coach).stream()
                    .collect(
                            Collectors.joining(" | ",String.format("[ %s | ",coach.getName())," ]\n")
                    )
            );
        }

        return result.toString();
    }

}
