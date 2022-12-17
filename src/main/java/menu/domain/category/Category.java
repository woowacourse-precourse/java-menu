package menu.domain.category;

public enum Category {

    JAPANESE("일식",0),
    KOREAN("한식", 0),
    CHINESE("중식", 0),
    ASIAN("아시안", 0),
    WESTERN("양식", 0);

    private final String category;
    private int count;

    public static Category findBy(String arg) {
        for (Category category : values()) {
            if (category.category.equals(arg)) {
                return category;
            }
        }
        return null;
    }

    public static void countUp(String arg){
        for (Category category : values()) {
            if (category.category.equals(arg)) {
                category.count++;
            }
        }
    }

    Category(final String category, final int count) {
        this.category = category;
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public int getCount(){
        return count;
    }

}
