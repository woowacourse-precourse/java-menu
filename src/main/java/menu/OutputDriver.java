package menu;

public class OutputDriver {
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");

    }

    public void printScanCannotEatMenuMessage(String name) {
        System.out.println("\n" + name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printResult(String menuListStringReturn) {
        System.out.println("\n메뉴 추천 결과입니다.\n");
        System.out.println(menuListStringReturn);
        System.out.println("\n추천을 완료했습니다.");
    }

    public void printScanCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printErrorForScanName() {
        System.out.println("[ERROR] 이름을 입력하실 때 맨 앞에 , 를 붙이면 안되고, 이름의 길이는 2 - 4 글자, 코치는 2 - 5명 까지만 가능합니다.");
    }

    public void printErrorForScanMenuNumber() {
        System.out.println("[ERROR] 못 먹는 메뉴는 0 - 2개 까지만 입력이 가능합니다.");
    }

    public void printErrorForScanSpliting() {
        System.out.println("[ERROR] 이름을 입력하실 때 맨 앞에 , 를 붙이시면 안됩니다.");
    }

    public void printErrorForScanTooManyCoach() {
        System.out.println("[ERROR] 코치는 최대 5명 이하만 입력헤야 합니다.");
    }

    public void printErrorForScanTooLessCoach() {
        System.out.println("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");System.out.println("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
    }

    public void printErrorForScanMenuSpliting() {
        System.out.println("[ERROR] 메뉴를 입력하실 때 맨 앞에 , 를 붙이시면 안됩니다.");
    }

    public void printErrorForScanMenuHasSpace() {
        System.out.println("[ERROR] 메뉴를 입력하실 때 공백을 넣으시면 안됩니다.");
    }
}
