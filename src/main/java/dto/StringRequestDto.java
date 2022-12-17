package dto;

public class StringRequestDto {
    private final String string;

    public StringRequestDto(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
