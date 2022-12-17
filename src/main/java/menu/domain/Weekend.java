package menu.domain;

public class Weekend {

    private Category category;
    private String datOfWeek;

    public Weekend(String dayOfWeek, Category nothing) {
        this.datOfWeek = dayOfWeek;
        this.category = nothing;
    }

    public String getDateOfWeek() {
        return datOfWeek;
    }

    public void createCategory(Category category){
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
