package menu;

public class OutputView {
    public void printServiceStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printServiceEnd(){
        System.out.println("메뉴 추천 결과입니다.");
        // TODO: 메뉴 추천 결과 출력
        System.out.println("추천을 완료했습니다.");
    }

    public void printRequireCoachName(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printRequireCantEatMenu(){
        // TODO: 코치 이름 출력
        System.out.println("(이)가 못 먹는 메뉴를 입력해 주세요.");
    }
}
