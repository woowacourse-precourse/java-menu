package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private List<String> japaneseMenu;
	private List<String> koreanMenu;
	private List<String> chineseMenu;
	private List<String> asianMenu;
	private List<String> westernMenu;

	private String[] japanese = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼".replace(" ", "").split(",");
	private String[] korean = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음".replace(" ", "").split(",");
	private String[] chinese = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채".replace(" ", "").split(",");
	private String[] asian = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜".replace(" ", "").split(",");
	private String[] western = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니".replace(" ", "").split(",");

	public Category() {
		this.japaneseMenu = new ArrayList<>(List.of(japanese));
		this.koreanMenu = new ArrayList<>(List.of(korean));
		this.chineseMenu = new ArrayList<>(List.of(chinese));
		this.asianMenu = new ArrayList<>(List.of(asian));
		this.westernMenu = new ArrayList<>(List.of(western));
	}

	public List<String> getJapaneseMenu() {
		return japaneseMenu;
	}

	public List<String> getKoreanMenu() {
		return koreanMenu;
	}

	public List<String> getChineseMenu() {
		return chineseMenu;
	}

	public List<String> getAsianMenu() {
		return asianMenu;
	}

	public List<String> getWesternMenu() {
		return westernMenu;
	}
}
