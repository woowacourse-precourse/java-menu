package menu.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultDto {

    private final List<String> categories;

    private final List<CompleteMenuDto> completeMenuDtos;

    public ResultDto(List<String> categories, List<CompleteMenuDto> completeMenuDtos) {
        this.categories = categories;
        this.completeMenuDtos = completeMenuDtos;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<CompleteMenuDto> getCompleteMenuDtos() {
        return completeMenuDtos;
    }
}
