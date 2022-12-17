package dto;

import java.util.Objects;

public class ObjectResponseDto {
    private final Objects objects;

    public ObjectResponseDto(Objects objects) {
        this.objects = objects;
    }

    public Objects getObjects() {
        return objects;
    }
}
