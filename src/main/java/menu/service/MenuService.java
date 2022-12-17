package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Member;
import menu.domain.Menu;
import menu.repo.MenuRepository;

import java.util.*;

import static menu.domain.Category.getCategory;

public class MenuService {
    private final MenuRepository menuRepository = MenuRepository.getInstance();
    private final MemberService memberService = new MemberService();
    private List<Category> weekCategory = new ArrayList<>();

    public void recommendMenu() {
        Category category;
        category = pickCategory();
        pickMenu(category);
    }

    private Category pickCategory() {
        Category category;
        do {
            category = getCategory(Randoms.pickNumberInRange(1, 5));
        } while (!isValidCategory(category));
        weekCategory.add(category);
        return category;
    }

    public void pickMenu(Category category) {
        List<String> menus = menuRepository.findMenusAllByCategory(category);
        List<Member> members = memberService.findAll();

        List<String> todayEat = new ArrayList<>();
        for (Member member : members) {
            String menu;
            do {
                menu = Randoms.shuffle(menus).get(0);
            } while (!isValidMenu(member, menu));
            todayEat.add(menu);
        }
        saveEatInfo(members, todayEat);
    }

    private void saveEatInfo(List<Member> members, List<String> todayEat) {
        for (int i = 0; i < members.size(); i++) {
            members.get(i).addWeekEat(todayEat.get(i));
        }
    }

    private boolean isValidMenu(Member member, String menu) {
        List<String> weekEats = memberService.findWeekEatAllByName(member.getName());
        List<String> notEats = memberService.findNotEatAllByName(member.getName());

        if (weekEats.contains(menu)) {
            return false;
        }
        if (notEats.contains(menu)) {
            return false;
        }
        return true;
    }

    private boolean isValidCategory(Category category) {
        int count = (int)weekCategory.stream()
                .filter(o -> o.equals(category)).count();
        if (count >= 2) {
            return false;
        }
        return true;
    }

    public void saveMenu() {
        menuRepository.save(new Menu(Category.JP, Arrays.asList(
                "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")));
        menuRepository.save(new Menu(Category.KOR, Arrays.asList(
                "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")));
        menuRepository.save(new Menu(Category.CN, Arrays.asList(
                "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")));
        menuRepository.save(new Menu(Category.AS, Arrays.asList(
                "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")));
        menuRepository.save(new Menu(Category.WS, Arrays.asList(
                "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")));
    }

    public List<Category> getWeekCategory() {
        return weekCategory;
    }

    public List<Member> getMembers() {
        return memberService.findAll();
    }

    public void saveMember(String name, List<String> notEats) {
        memberService.saveMember(new Member(name, notEats));
    }
}
