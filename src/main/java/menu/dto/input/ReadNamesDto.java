package menu.dto.input;

public class ReadNamesDto {
    private final String menuRecommendation;

    public ReadNamesDto(String readUserInput) {
        this.menuRecommendation = readUserInput;
    }

    public String getMenuRecommendation() {
        return menuRecommendation;
    }
}
