package menu.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import menu.domain.Couch;
import menu.dto.CouchHateMenusRequest;
import menu.dto.CouchNamesRequest;
import menu.repository.CouchRepository;
import menu.repository.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuServiceTest {

    CouchRepository couchRepository;
    MenuRepository menuRepository;
    MenuService menuService;

    @BeforeEach
    void setUp() {
        couchRepository = new CouchRepository();
        menuRepository = new MenuRepository();
        menuService = new MenuService(menuRepository, couchRepository);
    }

    @Test
    @DisplayName("코치가 정상적으로 저장되어야 한다.")
    void saveCouchCouldBeSuccess() {
        // given
        CouchNamesRequest request = CouchNamesRequest.of("하하,하하하");

        // when
        menuService.saveCouches(request);

        // then
        List<Couch> couches = couchRepository.findAll();
        assertThat(couches.size())
                .isEqualTo(2);
        assertThat(couches.get(0).getName())
                .isEqualTo("하하");
        assertThat(couches.get(1).getName())
                .isEqualTo("하하하");
    }

    @Test
    @DisplayName("코치가 싫어하는 메뉴가 정상적으로 저장되어야 한다.")
    void saveCouchHateMenuCouldBeSuccess() {
        // given
        CouchNamesRequest request = CouchNamesRequest.of("하하,하하하");
        menuService.saveCouches(request);
        Couch couch = couchRepository.findAll().get(0);
        CouchHateMenusRequest hateMenusRequest = CouchHateMenusRequest.of("김밥,김치찌개");

        // when
        menuService.addHateMenusForCouch(couch, hateMenusRequest);

        // then
        assertThat(couch.isHateMenu("김밥"))
                .isTrue();
        assertThat(couch.isHateMenu("김치찌개"))
                .isTrue();
    }

    @Test
    @DisplayName("코치가 싫어하는 메뉴가 등록될 때 해당 음식이 없으면 예외가 발생한다.")
    void saveCouchHateMenuByNoExistMenu() {
        // given
        CouchNamesRequest request = CouchNamesRequest.of("하하,하하하");
        menuService.saveCouches(request);
        Couch couch = couchRepository.findAll().get(0);
        CouchHateMenusRequest hateMenusRequest = CouchHateMenusRequest.of("음식");

        // expect
        assertThatThrownBy(() -> menuService.addHateMenusForCouch(couch, hateMenusRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("추천 카테고리가 정상적으로 추천되어야 한다.")
    void RecommendCategoryCouldBeSuccess() {
        // given
        List<String> recommendCategories = menuService.createRecommendCategories();
        // expect
        assertThat(recommendCategories.size())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("코치들의 추천 메뉴가 정상적으로 추천되어야 한다.")
    void recommendMenusForCouchesCouldBeSuccess() {
        // given
        CouchNamesRequest request = CouchNamesRequest.of("하하,하하하");
        menuService.saveCouches(request);
        List<String> recommendCategories = menuService.createRecommendCategories();

        // when
        menuService.createRecommendCouchMenu(recommendCategories);

        // then
        Couch couch = couchRepository.findAll().get(0);
        assertThat(couch.getRecommendsMenus().size())
                .isEqualTo(5);
    }
}