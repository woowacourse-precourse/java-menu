package menu.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import menu.domain.Category;
import menu.domain.Menu;

class MenuRepositoryTest {

	@Test
	void repoInitializeTest() {
		MenuRepository menuRepository = new MenuRepository();
		Map<Category, List<Menu>> menus = MenuRepository.menus();

		List<Menu> asian = menus.get(Category.ASIAN);

		Assertions.assertThat(asian.stream()
			.filter(menu -> menu.getName().equals("파인애플 볶음밥"))
			.count())
			.isEqualTo(1);
	}
	@Test
	void repoGetMenuListByCategoryTest() {
		MenuRepository menuRepository = new MenuRepository();

		List<Menu> menuList = MenuRepository.menusByCategory(Category.WESTERN);

		Assertions.assertThat(menuList.stream()
			.filter(menu -> menu.getName().equals("끼슈"))
			.count())
			.isEqualTo(1);
	}
}
