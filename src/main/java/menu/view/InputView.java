package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.utils.Converter;

import java.util.List;

public class InputView {
    private final Converter converter;

    public InputView(Converter converter) {
        this.converter = converter;
    }

    public List<String> getCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (,로 구분)");
        String names = Console.readLine();
        System.out.println();
        return converter.convertToList(names);
    }
}
