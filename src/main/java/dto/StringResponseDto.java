package dto;

public class StringResponseDto {
    private final String string;

    public StringResponseDto(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
