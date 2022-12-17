package menu.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String[] INPUT_COACH_NAME() {
        System.out.println(InputString.COACH_NAME_INPUT);
        try {
            String names = Console.readLine();
            String[] coaches = names.split(",");
            if (coaches.length < 2 || coaches.length > 5)
                throw new IllegalArgumentException("[ERROR] 코치는 2명 이상 5명 이하입니다.");
            for (String coach : coaches) {
                if (coach.length() < 2 || coach.length() > 4)
                    throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 입니다.");
            }
            return names.split(",");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return INPUT_COACH_NAME();
        }
    }

    public String[] CANNOT_EAT_FOOD(String name) {
        System.out.println(name + InputString.CANNOT_EAT_FOOD);
        try {
            try {
                String m = Console.readLine();
                return m.split(",");
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR]");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return CANNOT_EAT_FOOD(name);
        }
    }

}
