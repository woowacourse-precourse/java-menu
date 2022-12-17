package menu;

public class Category {
    static int[] thisWeekCategoryInfo = new int[6];
    public static FoodInformation recommendCategory(){
        while(true){
            FoodInformation foodInformation = FoodInformation.getRandomCategory();
            if(thisWeekCategoryInfo[foodInformation.getCategory()] >= 2)
                continue;

            ++thisWeekCategoryInfo[foodInformation.getCategory()];
            return foodInformation;
        }
    }
}
