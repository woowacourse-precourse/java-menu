package menu.domain.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomMenuStrategy implements MenuStrategy {
    @Override
    public List<String> generate(List<String> menuNames) {
        return Randoms.shuffle(menuNames);
    }
}
