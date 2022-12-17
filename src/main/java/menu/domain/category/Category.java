package menu.domain.category;

public class Category {
    private int id;
    private String name; // Enum화 가능?
    private int recommendedCount; // 이거 초기화 하는 방법


    public Category(String name){
        this.name = name;
        this.recommendedCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAlreadyRecommendedOver(int count){ // 네이밍 이상
        return recommendedCount > count;
    }

    public void updateRecommendedCount(){
        this.recommendedCount++;
    }
}
