package menu.dto;

import java.util.List;

public class NoEatsDto {
    private final List<NoEatDto> noEats;

    public NoEatsDto(List<NoEatDto> noEats) {
        this.noEats = noEats;
    }

    public List<NoEatDto> getNoEats() {
        return noEats;
    }
}
