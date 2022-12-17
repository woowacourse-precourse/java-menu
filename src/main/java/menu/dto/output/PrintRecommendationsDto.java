package menu.dto.output;

import menu.domain.People;

import java.util.List;

public class PrintRecommendationsDto {

    private final People people;
    private final List<String> shuffledCategory;

    public PrintRecommendationsDto(People people, List<String> shuffledCategory) {
        this.people = people;
        this.shuffledCategory = shuffledCategory;
    }

    public People getPeople() {
        return people;
    }

    public List<String> getShuffledCategory() {
        return shuffledCategory;
    }
}
