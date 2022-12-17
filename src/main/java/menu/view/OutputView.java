package menu.view;

public class OutputView {
    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRequestCrewsName() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printRequestOfBannedFoods(String crewName) {
        System.out.println("\n" + crewName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printResult() {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        // todo : 추후에 결과 출력을 위해 Crews와 Category 받기
    }
}
