package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomMenuSelector {
    public static String getRandomMenu(List<String> category) {
        return Randoms.shuffle(category).get(0);
    }
}
