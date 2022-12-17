package menu;

import org.junit.jupiter.api.Test;
import repository.MenuForWeekRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuRecommenderTest {
    @Test
    public void testMenuRecommender() {
        List<Coach> coaches = List.of(new Coach("승원"), new Coach("자인"));
        MenuForWeekRepository.initializeCoaches(coaches);
        MenuRecommender.addRecommendMenus(coaches);

    }
}