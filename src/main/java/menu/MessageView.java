package menu;

public class MessageView {
    public void serviceStartMessage(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
    public void coachNameMessage(){
        System.out.println("코치의 이름을 입력해 주세요.(,로 구분)");
    }
    public void coachNotEatMessage(String name){
        System.out.println(name +"(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void recommendMessage(){
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
    }
}
