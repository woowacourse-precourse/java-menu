package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class RecommendService {
    private static final int DAYS_COUNT = 5;
    private final MenuRepository menuRepository;
    private final MemberRepository memberRepository;

    public RecommendService() {
        menuRepository = RepositoryFactory.getMenuRepository();
        memberRepository = RepositoryFactory.getMemberRepository();
    }

    public List<MenuCategory> recommend() {
        List<MenuCategory> categories = getRandomCategory();
        List<Member> members = memberRepository.getAll();

        memberRepository.getAll()
                .forEach(m ->
                        categories.forEach(c -> {
                            String randomMenu = getCanEatMenu(m, c);
                            m.eat(menuRepository.findByName(randomMenu));
                        }));
        return categories;
    }

    private String getCanEatMenu(Member member, MenuCategory category) {
        while (true) {
            String randomMenu = getRandomMenu(menuRepository.findAllByCategory(category));
            if (member.isCanEat(menuRepository.findByName(randomMenu))) {
                return randomMenu;
            }
        }
    }

    private String getRandomMenu(List<Menu> menus) {
        List<String> mapToString = menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
        return Randoms.shuffle(mapToString).get(0);
    }

    private List<MenuCategory> getRandomCategory() {
        List<MenuCategory> ret = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        countInitSetting(count);
        while (ret.size() < DAYS_COUNT) {
            int number = Randoms.pickNumberInRange(1, 5);
            if (count.get(number) == 2) {
                continue;
            }
            count.put(number, count.get(number) + 1);
            ret.add(MenuCategory.get(number));
        }
        return ret;
    }

    private void countInitSetting(Map<Integer, Integer> count) {
        count.put(1, 0);
        count.put(2, 0);
        count.put(3, 0);
        count.put(4, 0);
        count.put(5, 0);
    }

}
