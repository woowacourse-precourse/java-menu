package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menu.domain.Category;
import menu.domain.Menu;

public class MenuRepository {

	private static final Map<Category, List<Menu>> menus = new HashMap<>();
	// TODO: 너무 길다
	static {
		List<String> japanese = List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
		List<String> korean = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
		List<String> chinese = List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
		List<String> asian = List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
		List<String> western = List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
		putter(1, japanese);
		putter(2, korean);
		putter(3, chinese);
		putter(4, asian);
		putter(5, western);

	}

	private static void putter(int categoryNum, List<String> menuNames) {
		Category category = Category.from(categoryNum);
		menus.put(category, new ArrayList<>());
		List<Menu> menuList = menus.get(category);
		for (String menuName : menuNames) {
			Menu menu = new Menu(menuName);
			menuList.add(menu);
		}
	}

	public static Map<Category, List<Menu>> menus() {
		return Collections.unmodifiableMap(menus);
	}
}
