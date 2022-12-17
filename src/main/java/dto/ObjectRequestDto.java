package dto;

import java.util.Objects;

public class ObjectRequestDto {
    private final Objects objects;

    public ObjectRequestDto(Objects objects) {
        this.objects = objects;
    }

    public Objects getObjects() {
        return objects;
    }
}
