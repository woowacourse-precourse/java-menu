package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Category {
    private static final List<FoodInformation> thisWeekCategoryInfo = new ArrayList<>();
    public static FoodInformation getProperCategory(){
        while(true){
            FoodInformation foodInformation = FoodInformation.getRandomCategory();
            if(Collections.frequency(thisWeekCategoryInfo, foodInformation) >= 2)
                continue;

            thisWeekCategoryInfo.add(foodInformation);
            return foodInformation;
        }
    }
    public static String getPrintForm(){
        String prefix = "[ 카테고리 | ";
        String suffix = " ]";

        return thisWeekCategoryInfo.stream()
                .map(FoodInformation::getCategoryName)
                .collect(Collectors.joining(" | ", prefix, suffix));
    }
}
