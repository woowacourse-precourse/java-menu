package menu.dto.request;

public class CoachNameDto {

    private static final int NAME_MAX_LENGTH = 4;
    private static final int NAME_MIN_LENGTH = 2;

    private final String name;

    public CoachNameDto(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다. 입력값 : " + name);
        }
    }
}
