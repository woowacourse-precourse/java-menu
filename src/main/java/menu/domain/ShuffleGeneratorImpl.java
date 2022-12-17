package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ShuffleGeneratorImpl implements ShuffleGenerator{

    @Override
    public List<String> generate(List<String> menus) {
        List<String> shuffledMenus = Randoms.shuffle(menus);
        return shuffledMenus;
    }
}
