package menu.dto.input;

public class ReadNamesDto {
    private final String names;

    public ReadNamesDto(String input) {
        this.names = input;
    }

    public String getNames() {
        return names;
    }
}
