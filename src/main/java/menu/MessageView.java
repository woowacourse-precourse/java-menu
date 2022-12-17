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
}
