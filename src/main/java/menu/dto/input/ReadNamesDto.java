package menu.dto.input;

public class ReadNamesDto {
    private final String userInput;

    public ReadNamesDto(String readUserInput) {
        this.userInput = readUserInput;
    }

    public String getUserInput() {
        return userInput;
    }
}
