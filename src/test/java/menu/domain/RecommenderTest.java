package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("Recommender 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class RecommenderTest {

    @Test
    void recommend_메서드는_추천_결과를_만들어낸다() {
        List<Category> categories = new ArrayList<>();
        List<Coach> coaches = List.of(new Coach(new CoachName("이름"), List.of()));

        Map<Category, List<String>> menus = Map.of(Category.JAPANESE, List.of("일식"),
                Category.KOREAN, List.of("한식", "일식"),
                Category.CHINESE, List.of("중식", "한식"),
                Category.ASIAN, List.of("아시안", "양식"),
                Category.WESTERN, List.of("양식", "아시안"));
        new Recommender(categories, menus, new MockedPicker()).recommend(coaches);
        assertThat(categories).containsExactly(
                Category.JAPANESE, Category.KOREAN, Category.CHINESE, Category.ASIAN, Category.WESTERN);
        assertThat(coaches.get(0).toDto()).containsExactly("이름", "일식", "한식", "중식", "아시안", "양식");
    }
}
