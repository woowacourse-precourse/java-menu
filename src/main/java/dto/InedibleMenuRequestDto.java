package dto;

public class InedibleMenuRequestDto {
    private final String inedibleMenu;

    public InedibleMenuRequestDto(String inedibleMenu) {
        this.inedibleMenu = inedibleMenu;
    }

    public String getInedibleMenu() {
        return inedibleMenu;
    }
}
