package menu;

public class Category {
    static int[] thisWeekCategoryInfo = new int[6];
    public static int recommendCategory(){
        FoodInfo foodInfo = new FoodInfo();
        while(true){
            int cand = foodInfo.getRandomCategory();
            if(thisWeekCategoryInfo[cand] >= 2)
                continue;

            ++thisWeekCategoryInfo[cand];
            return cand;
        }
    }
}
