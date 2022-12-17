package menu.domain;

public class MatchingCategory {
    private final String category;

    public MatchingCategory(int categoryNumber) {
        String category = null;
        if (categoryNumber == 1){
            category = "일식";
        }
        if (categoryNumber == 2){
            category = "한식";
        }
        if (categoryNumber == 3){
            category = "중식";
        }
        if (categoryNumber == 4){
            category = "아시안";
        }
        if (categoryNumber == 5){
            category = "양식";
        }
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
