package menu;

public class Category {
    private static final int[] thisWeekCategoryInfo = new int[6];
    public static FoodInformation getProperCategory(){
        while(true){
            FoodInformation foodInformation = FoodInformation.getRandomCategory();
            if(thisWeekCategoryInfo[foodInformation.getCategory()] >= 2)
                continue;

            ++thisWeekCategoryInfo[foodInformation.getCategory()];
            return foodInformation;
        }
    }
}
